package com.example.library.service;

import com.example.library.dao.MyDMFileImpl;
import com.example.library.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LibraryServiceTest {
    private LibraryService libraryService;

    @Before
    public void setUp() {
        MyDMFileImpl dao = new MyDMFileImpl("test_books.dat");
        libraryService = new LibraryServiceImpl(dao);
    }

    @Test
    public void testAddBook() throws IOException, ClassNotFoundException {
        Book book = new Book(1, "Test Book", "Test Author");
        libraryService.addBook(book);

        Book retrievedBook = libraryService.getBook(1);
        assertNotNull(retrievedBook);
        assertEquals(1, retrievedBook.getId());
        assertEquals("Test Book", retrievedBook.getTitle());
        assertEquals("Test Author", retrievedBook.getAuthor());
    }

    @Test
    public void testDeleteBook() throws IOException, ClassNotFoundException {
        Book book = new Book(1, "Test Book", "Test Author");
        libraryService.addBook(book);
        libraryService.deleteBook(1);

        Book retrievedBook = libraryService.getBook(1);
        assertNull(retrievedBook);
    }
}
