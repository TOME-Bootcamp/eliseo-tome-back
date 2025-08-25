package com.tome.tome.language

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepo : JpaRepository<Language, Long> {
    // El método saveAll ya está disponible por herencia de JpaRepository
    // Retorna: <S extends T> List<S> saveAll(Iterable<S> entities)
}