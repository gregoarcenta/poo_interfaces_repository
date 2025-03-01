package org.arcentales.interfaces.repository;

import org.arcentales.interfaces.model.Client;

import java.util.List;

public interface CrudRepository {
    List<Client> getClients();

    Client getClient(Integer id);

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Integer id);

}
