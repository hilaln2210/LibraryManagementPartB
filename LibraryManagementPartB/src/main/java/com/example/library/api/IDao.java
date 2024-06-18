package com.example.library.api;

import java.io.IOException;
import java.util.List;

public interface IDao<T> {
    List<T> load() throws IOException, ClassNotFoundException;
    void save(List<T> data) throws IOException;
}
