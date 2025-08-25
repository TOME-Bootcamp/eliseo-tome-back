package com.tome.tome.book

import com.tome.tome.book.exceptions.BookAlreadyExistsException
import com.tome.tome.bookDataDTO.BookDTO
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BookService(private val bookRepo: BookRepo) {

    // Buscar por título (ignorando mayúsculas/minúsculas)
    fun findByTitle(title: String): List<Book> {
        return bookRepo.findByTitleContainingIgnoreCase(title)
    }

    fun findById(bookId: UUID): Book? {
        return bookRepo.findById(bookId).orElse(null)
    }

    fun createBook(book: Book): Book {
        val existingBooks = findByTitle(book.title)
        if (existingBooks.isNotEmpty()) {
            throw BookAlreadyExistsException("Ya existe un libro con el mismo título y autor")
        }
        return bookRepo.save(book)
    }
    // Otros métodos del servicio pueden ir aquí

    fun updateBook(bookId: UUID, updatedBook: Book): Book {
        // Lógica para actualizar el libro con bookId usando los datos de updatedBook
        // Por simplicidad, asumimos que el libro se actualiza correctamente
        val book = bookRepo.save(updatedBook) // Reutilizamos createBook para guardar los cambios
        return book
    }
    fun deleteBook(bookId: UUID) {
        bookRepo.deleteById(bookId)
    }
}

