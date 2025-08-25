package com.tome.tome

import com.tome.tome.book.Book
import com.tome.tome.bookDataDTO.BookDTO

fun toDTO(book: Book): BookDTO = BookDTO(
    id = book.id,
    title = book.title,
)