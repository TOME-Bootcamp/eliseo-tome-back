package com.tome.tome.publisher

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepo : JpaRepository<Publisher, Long> {
    // El método saveAll ya está disponible por herencia de JpaRepository
    // Retorna: <S extends T> List<S> saveAll(Iterable<S> entities)
}