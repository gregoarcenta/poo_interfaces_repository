package org.arcentales.poointerfaces.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCrudRepository<T>
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
    public void create(T data) {
        this.datasource.add(data);
    }

    @Override
    public void remove(Integer id) {
        T c = this.getById(id);
        if (c != null) datasource.remove(c);
    }

}
