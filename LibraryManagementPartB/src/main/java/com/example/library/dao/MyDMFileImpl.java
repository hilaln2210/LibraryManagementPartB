package com.example.library.dao;

import com.example.library.api.IDao;
import com.example.library.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyDMFileImpl implements IDao<Book> {
    private final String pathFile;

    public MyDMFileImpl(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public List<Book> load() throws IOException, ClassNotFoundException {
        File file = new File(pathFile);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Book>) ois.readObject();
        }
    }

    @Override
    public void save(List<Book> data) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFile))) {
            oos.writeObject(data);
        }
    }
}
