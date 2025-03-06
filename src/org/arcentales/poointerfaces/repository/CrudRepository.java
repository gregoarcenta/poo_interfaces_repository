package org.arcentales.poointerfaces.repository;

import org.arcentales.poointerfaces.repository.exceptions.AccessDataException;

import java.util.List;

public interface CrudRepository<T> {
    List<T> getAll();

    T getById(Integer id) throws AccessDataException;

    void create(T client) throws AccessDataException;

    void update(T client) throws AccessDataException;

    void remove(Integer id) throws AccessDataException;
}
