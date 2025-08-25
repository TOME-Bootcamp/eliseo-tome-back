package com.tome.tome.tag

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepo : JpaRepository<Tag, Long> {
    // El método saveAll ya está disponible por herencia de JpaRepository
    // Retorna: <S extends T> List<S> saveAll(Iterable<S> entities)
}