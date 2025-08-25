package com.tome.tome.book

import com.tome.tome.book.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BookRepo : JpaRepository<Book, UUID> {

    // Buscar por título (ignorando mayúsculas/minúsculas)
    fun findByTitleContainingIgnoreCase(title: String): List<Book>

}