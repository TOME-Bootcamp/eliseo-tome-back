package com.tome.tome.seed

import <TU.PAQUETE>.book.Book
import <TU.PAQUETE>.book.BookRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path

data class SeedBook(
    val title: String,
    val coverUrl: String,
    val author: String,
    val synopsis: String?,
    val isbn: String,
    val year: Int?,
    val publisher: String?,
    val language: String?,
    val pages: Int?,
    val tags: Set<String>?
)

@Component
@ConditionalOnProperty(prefix = "app.seed", name = ["enabled"], havingValue = "true")
class BookSeedRunner(private val repo: BookRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val mapper = jacksonObjectMapper()
        val path = System.getProperty("app.seed.file") ?: "classpath:seed/books.json"
        val json: String = readFile(path)
        val items: List<SeedBook> = mapper.readValue(json)

        items.forEach { sb ->
            if (!repo.existsByIsbn(sb.isbn)) {
                repo.save(
                    Book(
                        title = sb.title,
                        coverUrl = sb.coverUrl,
                        author = sb.author,
                        synopsis = sb.synopsis,
                        isbn = sb.isbn,
                        year = sb.year,
                        publisher = sb.publisher,
                        language = sb.language,
                        pages = sb.pages,
                        tags = (sb.tags ?: emptySet()).toMutableSet()
                    )
                )
            }
        }

        if (System.getProperty("app.seed.exit") == "true") {
            kotlin.system.exitProcess(0)
        }
    }

    private fun readFile(path: String): String {
        return if (path.startsWith("classpath:")) {
            val resPath = path.removePrefix("classpath:")
            val resource: Resource = ClassPathResource(resPath)
            resource.inputStream.bufferedReader().use { it.readText() }
        } else {
            Files.readString(Path.of(path))
        }
    }
}
