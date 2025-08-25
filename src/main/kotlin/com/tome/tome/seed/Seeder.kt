package com.tome.tome.seed

import com.tome.tome.book.Book
import com.tome.tome.author.Author
import com.tome.tome.author.AuthorRepo
import com.tome.tome.publisher.Publisher
import com.tome.tome.publisher.PublisherRepo
import com.tome.tome.tag.TagRepo
import com.tome.tome.book.BookRepo
import com.tome.tome.language.Language
import com.tome.tome.language.LanguageRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import com.tome.tome.tag.Tag
@Component
class BookSeeder(
    private val booksRepository: BookRepo,
    private val tagsRepo: TagRepo,
    private val authorRepo: AuthorRepo,
    private val publisherRepo: PublisherRepo,
    private val languageRepo: LanguageRepo,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        seedAuthor()
        seedPublisher()
        seedTags()
        seedLanguage()
        seedBooks()
    }

    private fun seedPublisher() {
        val publisher =
            listOf<Publisher>(
                Publisher(
                    "Ivrea",
                ),
            )
        publisherRepo.saveAll(publisher)
    }

    private fun seedAuthor() {
        val author = listOf<Author>(
            Author(
                id = null,
                name = "J.R.R",
                surname = "Tolkien",
                biography = "British author and philologist"
            )
        )
        authorRepo.saveAll(author)
    }

    private fun seedTags() {
        val tags = listOf<Tag>(
            Tag("Fantasy")
        )
        tagsRepo.saveAll(tags)
    }

    private fun seedLanguage() {
        val languages = listOf<Language>(
            Language("Spanish"),
        )
        languageRepo.saveAll(languages)
        // Implement language seeding if necessary
    }
    private fun seedBooks() {
        val author = authorRepo.findAll().first()
        val publisher = publisherRepo.findAll().first()
        val tag = tagsRepo.findAll().first()
        val language = languageRepo.findAll().first()
        val books =
            listOf<Book>(
                Book(
                    id = null,
                    title = "The Fellowship of the Ring",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1651340688i/727798.jpg",
                    synopsis = "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                            "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                            "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.",
                    isbn = "9780547928210",
                    year = 1954,
                    authors = listOf(author),
                    publishers = listOf(publisher),
                    pages = 407,
                    tags = listOf(tag),
                    languages = listOf(language),
                ),
            )
        booksRepository.saveAll(books)
    }
}
