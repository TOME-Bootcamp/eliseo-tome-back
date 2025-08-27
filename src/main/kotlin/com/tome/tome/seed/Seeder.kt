package com.tome.tome.seed

import com.tome.tome.book.Book
import com.tome.tome.author.Author
import com.tome.tome.author.AuthorRepo
import com.tome.tome.publisher.Publisher
import com.tome.tome.publisher.PublisherRepo
import com.tome.tome.tag.TagRepo
import com.tome.tome.book.BookRepo
import com.tome.tome.language.Language
import com.tome.tome.language.LanguageRepo
import com.tome.tome.tag.Tag
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BookSeeder(
    private val booksRepository: BookRepo,
    private val tagsRepo: TagRepo,
    private val authorRepo: AuthorRepo,
    private val publisherRepo: PublisherRepo,
    private val languageRepo: LanguageRepo,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        seedAuthor()
        seedPublisher()
        seedTags()
        seedLanguage()
        seedBooks()
    }

    private fun seedPublisher() {
        val publisher =
            listOf<Publisher>(
                Publisher("William Morrow"),
                Publisher("Atria Books"),
                Publisher("Dragonsteel Entertainment"),
                Publisher("Ace"),
            )
        publisherRepo.saveAll(publisher)
    }

    private fun seedAuthor() {
        val author =
            listOf<Author>(
                Author(
                    id = null,
                    name = "J.R.R",
                    surname = "Tolkien",
                    biography = "British author and philologist"
                ),
                Author(
                    id = null,
                    name = "Fredrik",
                    surname = "Backman",
                    biography = "Swedish author and columnist"
                ),
                Author(
                    id = null,
                    name = "Brandon",
                    surname = "Sanderson",
                    biography = "American fantasy and science fiction author"
                ),
                Author(
                    id = null,
                    name = "Frank",
                    surname = "Herbert",
                    biography = "American science fiction author"
                ),
            )
        authorRepo.saveAll(author)
    }

    private fun seedTags() {
        val tags =
            listOf<Tag>(
                Tag("Fantasy"),
                Tag("Fiction"),
                Tag("Science Fiction"),
                Tag("Contemporary"),
            )
        tagsRepo.saveAll(tags)
    }

    private fun seedLanguage() {
        val languages = listOf<Language>(
            Language("English"),
        )
        languageRepo.saveAll(languages)
    }

    private fun seedBooks() {
        val authorTolkien = authorRepo.findAll().find { it.name == "J.R.R" }!!
        val authorBackman = authorRepo.findAll().find { it.name == "Fredrik" }!!
        val authorSanderson = authorRepo.findAll().find { it.name == "Brandon" }!!
        val authorHerbert = authorRepo.findAll().find { it.name == "Frank" }!!

        val publisherMorrow = publisherRepo.findAll().find { it.name == "William Morrow" }!!
        val publisherAtria = publisherRepo.findAll().find { it.name == "Atria Books" }!!
        val publisherDragonsteel = publisherRepo.findAll().find { it.name == "Dragonsteel Entertainment" }!!
        val publisherAce = publisherRepo.findAll().find { it.name == "Ace" }!!

        val tagFantasy = tagsRepo.findAll().find { it.name == "Fantasy" }!!
        val tagFiction = tagsRepo.findAll().find { it.name == "Fiction" }!!
        val tagSciFi = tagsRepo.findAll().find { it.name == "Science Fiction" }!!

        val language = languageRepo.findAll().first()

        val books =
            listOf<Book>(
                Book(
                    id = null,
                    title = "The Fellowship of the Ring",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1651340688i/727798.jpg",
                    synopsis = "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                            "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                            "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, " +
                            "forged the One Ring, filling it with his own power so that he could rule all others. But the One " +
                            "Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him." +
                            " After many ages it fell into the hands of Bilbo " +
                            "Baggins, as told in The Hobbit. In a sleepy village in the Shire, " +
                            "young Frodo Baggins finds himself faced with an immense task," +
                            " as his elderly cousin Bilbo entrusts the Ring to his " +
                            "care. Frodo must leave his home and make a perilous " +
                            "journey across Middle-earth to the Cracks of Doom, there to " +
                            "destroy the Ring and foil the Dark Lord in his evil purpose.",
                    isbn = "9780547928210",
                    year = 1954,
                    authors = listOf(authorTolkien),
                    publishers = listOf(publisherMorrow),
                    pages = 407,
                    tags = listOf(tagFantasy),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "The Two Towers",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1629308732i/727800.jpg",
                    synopsis = "Begin your journey into Middle-earth.\n" +
                            "The inspiration for the upcoming original series " +
                            "on Prime Video, The Lord of the Rings: The Rings of Power.\n" +
                            "The Two Towers is the second part" +
                            " of J.R.R. Tolkien's epic adventure The Lord of the Rings.\n" +
                            "One Ring to rule them all, One Ring to " +
                            "find them, One Ring to bring them all and in the darkness bind them.\n" +
                            "Frodo and his Companions of " +
                            "the Ring have been beset by danger during " +
                            "their quest to prevent the Ruling Ring from falling into the " +
                            "hands of the Dark Lord by destroying it in the Cracks of Doom. They " +
                            "have lost the wizard, Gandalf, in a battle in the Mines of Moria. And Boromir," +
                            " seduced by the power of the Ring, tried to seize it by force. While Frodo and " +
                            "Sam made their escape, the rest of the company was attacked by Orcs. Now they " +
                            "continue the journey alone down the great River Anduin—alone, that is, save for" +
                            " the mysterious creeping figure that follows wherever they go.",
                    isbn = "9780261102361",
                    year = 1954,
                    authors = listOf(authorTolkien),
                    publishers = listOf(publisherMorrow),
                    pages = 448,
                    tags = listOf(tagFantasy),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "The Return of the King",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1634055544i/727810.jpg",
                    synopsis = "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                            "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                            "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, " +
                            "forged the One Ring, filling it with his own power so that he could rule all others." +
                            " But the One Ring was taken from him, and though he sought it throughout Middle-earth, " +
                            "it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told " +
                            "in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced" +
                            " with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must " +
                            "leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to " +
                            "destroy the Ring and foil the Dark Lord in his evil purpose.",
                    isbn = "9780261102378",
                    year = 1955,
                    authors = listOf(authorTolkien),
                    publishers = listOf(publisherMorrow),
                    pages = 432,
                    tags = listOf(tagFantasy),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "My Friends",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1734625930i/217163697.jpg",
                    synopsis = "\"The world is full of miracles, but none greater than how far a " +
                            "young person can be carried by someone else's belief in them.\"\n" +
                            "\n" +
                            "Most people don’t even notice them—three tiny figures sitting at the end of a " +
                            "long pier in the corner of one of the most famous paintings in the world." +
                            " Most people think it’s just a depiction of a wide expanse of sea. But Louisa, soon to be eighteen years " +
                            "old and an aspiring artist herself, knows otherwise. She is determined to find out the story behind these " +
                            "three enigmatic figures.\n" +
                            "\n" +
                            "More than two decades before, in a distant seaside town, a group of teenagers find refuge from their " +
                            "bruising home lives by spending long summer days on an abandoned pier telling silly jokes, sharing" +
                            " secrets, and committing small acts of rebellion. These lost souls find in each other a reason to get up " +
                            "every morning, a reason to dream, a reason to love.\n" +
                            "\n" +
                            "Out of that summer emerges a transcendent work of art, a painting that, after a chance encounter in an " +
                            "alleyway, will unexpectedly be placed into Louisa’s care. She embarks on a surprise-filled cross-country " +
                            "journey to discover how the painting came to be and to decide what to do with it. The closer she gets " +
                            "to the painting’s birthplace, the more anxious she becomes about what she'll find. Louisa's complicated life is " +
                            "proof that happy endings are sometimes possible, but they don't always take the form we expect them to.\n" +
                            "\n" +
                            "Fredrik Backman's signature charm, humor, and attention to the poignant " +
                            "details of everyday life are on full display in this funny, moving " +
                            "novel. His most heartfelt and personal tale yet, My Friends is a stunning testament to " +
                            "the transformative, timeless power of art and friendship.",
                    isbn = "9781982112820",
                    year = 2025,
                    authors = listOf(authorBackman),
                    publishers = listOf(publisherAtria),
                    pages = 436,
                    tags = listOf(tagFiction),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "Beartown",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1525349525i/31443394.jpg",
                    synopsis = "People say Beartown is finished. A tiny community nestled deep in the forest...",
                    isbn = "9781501160769",
                    year = 2017,
                    authors = listOf(authorBackman),
                    publishers = listOf(publisherAtria),
                    pages = 418,
                    tags = listOf(tagFiction),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "And Every Morning the Way Home Gets Longer and Longer",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1472074835i/31373633.jpg",
                    synopsis = "From the New York Times bestselling author of A Man Called Ove...",
                    isbn = "9781501160578",
                    year = 2015,
                    authors = listOf(authorBackman),
                    publishers = listOf(publisherAtria),
                    pages = 97,
                    tags = listOf(tagFiction),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "Tress of the Emerald Sea",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1672574587i/60531406.jpg",
                    synopsis = "The only life Tress has known on her island home in an emerald-green ocean...",
                    isbn = "",
                    year = 2023,
                    authors = listOf(authorSanderson),
                    publishers = listOf(publisherDragonsteel),
                    pages = 443,
                    tags = listOf(tagFantasy),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "Yumi and the Nightmare Painter",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1689135481i/60531416.jpg",
                    synopsis = "Yumi comes from a land of gardens, meditation, and spirits...",
                    isbn = "9781938570377",
                    year = 2023,
                    authors = listOf(authorSanderson),
                    publishers = listOf(publisherDragonsteel),
                    pages = 480,
                    tags = listOf(tagFantasy),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "The Sunlit Man",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1696146860i/60531420.jpg",
                    synopsis = "Running. Putting distance between himself and the relentless Night Brigade...",
                    isbn = "9781938570391",
                    year = 2023,
                    authors = listOf(authorSanderson),
                    publishers = listOf(publisherDragonsteel),
                    pages = 447,
                    tags = listOf(tagFantasy),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "Dune",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1555447414i/44767458.jpg",
                    synopsis = "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides...",
                    isbn = "9780593099322",
                    year = 1965,
                    authors = listOf(authorHerbert),
                    publishers = listOf(publisherAce),
                    pages = 658,
                    tags = listOf(tagSciFi),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "Dune Messiah",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1577043824i/44492285.jpg",
                    synopsis = "Dune Messiah continues the story of Paul Atreides...",
                    isbn = "9780593098233",
                    year = 1969,
                    authors = listOf(authorHerbert),
                    publishers = listOf(publisherAce),
                    pages = 336,
                    tags = listOf(tagSciFi),
                    languages = listOf(language),
                ),
                Book(
                    id = null,
                    title = "Children of Dune",
                    coverUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1564783201i/44492286.jpg",
                    synopsis = "The Children of Dune are twin siblings Leto and Ghanima Atreides...",
                    isbn = "9780593098240",
                    year = 1976,
                    authors = listOf(authorHerbert),
                    publishers = listOf(publisherDragonsteel),
                    pages = 609,
                    tags = listOf(tagSciFi),
                    languages = listOf(language),
                ),
            )
        booksRepository.saveAll(books)
    }
}
