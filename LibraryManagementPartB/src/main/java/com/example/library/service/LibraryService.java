package com.example.library.service;

import com.example.library.model.Book;

import java.io.IOException;
import java.util.List;

public interface LibraryService {
    void addBook(Book book) throws IOException, ClassNotFoundException;
    Book getBook(int id) throws IOException, ClassNotFoundException;
    void deleteBook(int id) throws IOException, ClassNotFoundException;
    List<Book> searchBooksByTitle(String title) throws IOException, ClassNotFoundException;
}
