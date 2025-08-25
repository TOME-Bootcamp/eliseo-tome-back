package com.tome.tome.author

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepo : JpaRepository<Author, Long> {
    // El método saveAll ya está disponible a través de JpaRepository
    // Retorna: <S extends T> List<S> saveAll(Iterable<S> entities)
}

