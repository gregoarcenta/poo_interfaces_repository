package org.arcentales.poointerfaces.repository;

import java.util.List;

public interface OrdenableRepository<T> {
    List<T> getAll(String field, Direction dir);
}
