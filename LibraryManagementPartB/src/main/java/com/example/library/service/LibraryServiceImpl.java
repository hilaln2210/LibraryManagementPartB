package com.example.library.service;

import com.example.library.api.IDao;
import com.example.library.model.Book;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {
    private final IDao<Book> dao;

    public LibraryServiceImpl(IDao<Book> dao) {
        this.dao = dao;
    }

    @Override
    public void addBook(Book book) throws IOException, ClassNotFoundException {
        List<Book> books = dao.load();
        books.add(book);
        dao.save(books);
    }

    @Override
    public Book getBook(int id) throws IOException, ClassNotFoundException {
        List<Book> books = dao.load();
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteBook(int id) throws IOException, ClassNotFoundException {
        List<Book> books = dao.load();
        books.removeIf(book -> book.getId() == id);
        dao.save(books);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) throws IOException, ClassNotFoundException {
        List<Book> books = dao.load();
        return books.stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }
}
