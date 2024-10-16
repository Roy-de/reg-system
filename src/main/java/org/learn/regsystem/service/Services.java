package org.learn.regsystem.service;

import java.util.List;
import java.util.UUID;

public interface Services<T, Y> {
    // Crud operations
    T create(Y y) throws Exception;
    T update(Y y) throws Exception;
    void delete(Y y) throws Exception;
    List<T> findAll() throws Exception;
    T findById(UUID id) throws Exception;
    T login(Y y) throws Exception;

}