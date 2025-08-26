package com.tome.tome.publisher

import com.tome.tome.book.Book
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.util.UUID

@Entity
class Publisher(
    val name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id : UUID? = null

    @ManyToMany(mappedBy = "publishers")
    val books: List<Book> = emptyList()
}