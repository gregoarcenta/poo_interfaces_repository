package org.arcentales.poointerfaces.repository;

import org.arcentales.poointerfaces.model.BaseEntity;
import org.arcentales.poointerfaces.repository.exceptions.ReadAccessDataException;
import org.arcentales.poointerfaces.repository.exceptions.WriteAccessDataException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCrudRepository<T extends BaseEntity>
        implements CrudRepository<T>, PaginableRepository<T>, OrdenableRepository<T> {
    protected final List<T> datasource;

    public AbstractCrudRepository() {
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<T> getAll() {
        return this.datasource;
    }

    @Override
    public List<T> getAll(int from, int to) {
        return this.datasource.subList(from, to);
    }

    @Override
    public T getById(Integer id) throws ReadAccessDataException {
        if (id == null || id <= 0) {
            throw new ReadAccessDataException("Invalid ID, must be greater than 0");
        }
        T result = null;
        for (T c : datasource) {
            if (c.getId().equals(id)) result = c;
        }
        if (result == null) {
            throw new ReadAccessDataException("Could not find entity with id " + id);
        }
        return result;
    }

    @Override
    public void create(T object) throws WriteAccessDataException {
        if (object == null) throw new WriteAccessDataException("");

        if (this.datasource.contains(object)) {
            throw new WriteAccessDataException("This object with id " + object.getId() + " already exists");
        }

        this.datasource.add(object);
    }

    @Override
    public void remove(Integer id) throws ReadAccessDataException {
        T c = this.getById(id);
        if (c != null) datasource.remove(c);
    }

}
