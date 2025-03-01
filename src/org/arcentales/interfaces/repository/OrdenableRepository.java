package org.arcentales.interfaces.repository;

import org.arcentales.interfaces.model.Client;

import java.util.List;

public interface OrdenableRepository {
    List<Client> getClients(String field, Direction dir);
}
