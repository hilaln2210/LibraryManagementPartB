package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.LibraryService;

import java.io.IOException;
import java.util.List;

public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void addBook(Book book) throws IOException, ClassNotFoundException {
        libraryService.addBook(book);
    }

    public Book getBook(int id) throws IOException, ClassNotFoundException {
        return libraryService.getBook(id);
    }

    public void deleteBook(int id) throws IOException, ClassNotFoundException {
        libraryService.deleteBook(id);
    }

    public List<Book> searchBooksByTitle(String title) throws IOException, ClassNotFoundException {
        return libraryService.searchBooksByTitle(title);
    }
}
