package org.arcentales.interfaces.repository;

import org.arcentales.interfaces.model.Client;

import java.util.List;

public interface PaginableRepository {
    List<Client> getClients(int from, int to);
}
