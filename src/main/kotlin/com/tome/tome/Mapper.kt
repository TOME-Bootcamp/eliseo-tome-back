package com.tome.tome

import com.tome.tome.book.Book
import com.tome.tome.book.dto.BookDTO

fun toDTO(book: Book): BookDTO = BookDTO(
    id = book.id,
    title = book.title,
)

fun toDataDTO(book: Book) = com.tome.tome.book.dto.BookDataDTO(
    id = book.id,
    title = book.title,
    coverUrl = book.coverUrl,
    synopsis = book.synopsis,
    isbn = book.isbn,
    year = book.year,
    authors = book.authors.map { it.name },
    publishers = book.publishers.map { it.name },
    languages = book.languages.map { it.name },
    pages = book.pages,
    tags = book.tags.map { it.name }
)
