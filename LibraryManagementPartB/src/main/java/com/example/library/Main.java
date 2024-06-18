package com.example.library;

import com.example.library.controller.LibraryController;
import com.example.library.dao.MyDMFileImpl;
import com.example.library.model.Book;
import com.example.library.service.LibraryService;
import com.example.library.service.LibraryServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyDMFileImpl dao = new MyDMFileImpl("books.dat");
        LibraryService libraryService = new LibraryServiceImpl(dao);
        LibraryController libraryController = new LibraryController(libraryService);

        try {
            Book book1 = new Book(1, "Book One", "Author One");
            Book book2 = new Book(2, "Book Two", "Author Two");

            libraryController.addBook(book1);
            libraryController.addBook(book2);

            Book foundBook = libraryController.getBook(1);
            System.out.println("Found book: " + foundBook.getTitle());

            libraryController.deleteBook(1);

            List<Book> books = libraryController.searchBooksByTitle("Two");
            books.forEach(book -> System.out.println("Found book: " + book.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
