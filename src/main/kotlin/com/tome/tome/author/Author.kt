package com.tome.tome.author

import com.tome.tome.book.Book
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.util.UUID

@Entity
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val name: String,
    val surname: String,
    val biography: String? = null
) {
    @ManyToMany(mappedBy = "authors")
    val books: List<Book> = emptyList()
}