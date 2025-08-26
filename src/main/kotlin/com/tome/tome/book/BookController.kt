package com.tome.tome.book

import com.tome.tome.book.dto.BookDTO
import com.tome.tome.book.dto.BookDataDTO
import com.tome.tome.book.exceptions.BookAlreadyExistsException
import com.tome.tome.toDTO
import com.tome.tome.toDataDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID
//para salir en el controlador
//convertir DTO es lo que hace el creador
//manejo de errores, excepciones, etc


@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

    private fun findBookOrThrow(bookId: UUID): Book {
        return bookService.findById(bookId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado")
    }

    @GetMapping
    fun getAllBooksDTO(): List<BookDataDTO> {
        return bookService.getAllBooks().map(::toDataDTO)
    }

    @GetMapping("/{bookId}")
    fun getBookById(@PathVariable bookId: UUID): BookDTO {
        val book = findBookOrThrow(bookId)
        return toDTO(book)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(book : Book) : BookDTO {
        try {
            val createdBook = bookService.createBook(book)
            return toDTO(createdBook)

        }catch (ex: BookAlreadyExistsException){
            throw ResponseStatusException(HttpStatus.CONFLICT, "El libro ya existe")
        }
    }

    @PutMapping("/{bookId}")
    fun updateBook(@PathVariable bookId: UUID, updatedBook: Book): BookDTO {
        findBookOrThrow(bookId)
        val book = bookService.updateBook(bookId, updatedBook)
        return toDTO(book)
    }

    @DeleteMapping("/{bookId}")
    fun deleteBook(@PathVariable bookId: UUID) {
        findBookOrThrow(bookId)
        bookService.deleteBook(bookId)
    }


}