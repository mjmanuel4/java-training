package test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.library.book.Book;
import org.library.service.LibraryService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

class LibraryServiceTest {
    private static Logger logger;
    private LibraryService libraryService;
    private Book book;

    @BeforeEach
    public void setUp() {
        logger = LogManager.getLogger(LibraryServiceTest.class);
        logger.info("Set up");

        book = new Book("Title", "Author", Long.parseLong("12345"));
        libraryService = new LibraryService();
        libraryService.addBook(book);
    }

    @Test
    public void testAddBook() {
        logger.info("Testing method addBook()");
        Book newBook = new Book("Title 2", "Author 2", Long.parseLong("23456"));
        libraryService.addBook(newBook);

        Assertions.assertEquals(2,libraryService.getSize());
    }

    @Test
    public void testRemoveBook() {
        logger.info("Testing method removeBook()");
        libraryService.removeBook(book);

        Assertions.assertEquals(0,libraryService.getSize());
    }

    @Test
    public void testRetrieveBook() {
        logger.info("Testing method retrieveBook()");
        Book retrieved = libraryService.retrieveBook(book);

        Assertions.assertEquals(book.getTitle(),retrieved.getTitle());
        Assertions.assertEquals(book.getAuthor(),retrieved.getAuthor());
        Assertions.assertEquals(book.getIsbn(),retrieved.getIsbn());
    }

    @Test
    public void testGetSize(){
        logger.info("Testing method getSize()");
        Assertions.assertEquals(1,libraryService.getSize());
    }
}