package com.tome.tome.book.dto

import java.util.UUID

data class BookDataDTO(
    val id: UUID?,
    val title: String,
    val coverUrl: String,
    val synopsis: String,
    val isbn: String,
    val year: Int,
    val authors: List<String>,
    val publishers: List<String>,
    val languages: List<String>,
    val pages: Int,
    val tags: List<String>
)