package org.library.book;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BookTest {
    private static Logger logger;
    private static Book book;

    @BeforeAll
    public static void setUp(){
        logger = LogManager.getLogger(BookTest.class);
        logger.info("Set up");
        book = new Book("Title", "Author", Long.parseLong("12345"));
    }

    @Test
    public void getTitle() {
        logger.info("Testing method getTitle()");
        Assertions.assertEquals("Title", book.getTitle());
    }

    @Test
    public void getAuthor() {
        logger.info("Testing method getAuthor()");
        Assertions.assertEquals("Author", book.getAuthor());
    }

    @Test
    public void getIsbn() {
        logger.info("Testing method getIsbn");
        Assertions.assertEquals(Long.parseLong("12345"), book.getIsbn());
    }

    @Test
    public void setTitle() {
        logger.info("Testing method setTitle()");
        book.setTitle("New Title");
        Assertions.assertEquals("New Title", book.getTitle());
    }

    @Test
    public void setAuthor() {
        logger.info("Testing method setAuthor()");
        book.setAuthor("New Author");
        Assertions.assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void setIsbn() {
        logger.info("Testing method setIsbn()");
        book.setIsbn(Long.parseLong("67890"));
        Assertions.assertEquals(Long.parseLong("67890"), book.getIsbn());
    }
}