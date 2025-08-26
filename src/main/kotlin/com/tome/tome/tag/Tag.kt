package com.tome.tome.tag

import com.tome.tome.book.Book
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.util.UUID

@Entity
class Tag (val name: String
){

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null

    @ManyToMany(mappedBy = "tags")
    val books: List<Book> = emptyList()

    // You can add more properties as needed
    // For example, a description or a color associated with the tag
}