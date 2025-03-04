package org.arcentales.poointerfaces.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> getAll();

    T getById(Integer id);

    void create(T client);

    void update(T client);

    void remove(Integer id);
}
