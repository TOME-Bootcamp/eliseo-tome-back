package com.tome.tome.book
import com.tome.tome.author.Author
import com.tome.tome.language.Language
import com.tome.tome.publisher.Publisher
import com.tome.tome.tag.Tag
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import java.util.UUID

//titulo, URL de la portada, autor, sinopsis,
//ISBN, año, publicador, lenguaje, páginas y etiquetas.

@Entity
//@Table(name = "Books") opcional, pq el spring data jpa lo crea automaticamente
class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val title: String,
    @Column(length = 1000) // URLs pueden ser muy largas
    val coverUrl: String,

    @Column(length = 4000) // Sinopsis suelen ser textos largos
    val synopsis: String,
    val isbn: String,
    val year: Int,

    @ManyToMany
    @JoinTable(
        name = "book_author",                                  // Tabla intermedia
        joinColumns = [JoinColumn(name = "book_id")],          // FK hacia Book
        inverseJoinColumns = [JoinColumn(name = "author_id")]  // FK hacia Author
    )
    val authors: List<Author> = emptyList(),

    @ManyToMany
    @JoinTable(
        name = "book_publisher",
        joinColumns = [JoinColumn(name = "book_id")],          // FK hacia Book
        inverseJoinColumns = [JoinColumn(name = "publisher_id")] // FK hacia Publisher
    )

    val publishers: List<Publisher>? = emptyList(),

    @ManyToMany
    @JoinTable(
        name = "book_language",
        joinColumns = [JoinColumn(name = "book_id")],          // FK hacia Book
        inverseJoinColumns = [JoinColumn(name = "language_id")] // FK hacia Language
    )

    val languages: List<Language>? = emptyList(), // Assuming Language is a String, otherwise create a Language entity
    @Column()
    val pages: Int,

    @ManyToMany
    @JoinTable(
        name = "book_tag",
        joinColumns = [JoinColumn(name = "book_id")],          // FK hacia Book
        inverseJoinColumns = [JoinColumn(name = "tag_id")]     // FK hacia Tag
    )
    val tags: List<Tag>? = emptyList(),
) {
    // Additional methods or properties can be added here if needed
}