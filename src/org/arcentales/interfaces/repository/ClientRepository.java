package org.arcentales.interfaces.repository;

import org.arcentales.interfaces.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements CrudRepository, PaginableRepository, OrdenableRepository {
    private List<Client> datasource;

    public ClientRepository() {
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<Client> getClients() {
        return this.datasource;
    }

    @Override
    public List<Client> getClients(int from, int to) {
        return this.datasource.subList(from, to);
    }

    @Override
    public List<Client> getClients(String field, Direction dir) {
        this.datasource.sort((c1, c2) -> {
            if (dir == Direction.ASC) {
                switch (field) {
                    case "id":
                        return c1.getId().compareTo(c2.getId());
                    case "name":
                        return c1.getName().compareTo(c2.getName());
                }
            } else {
                switch (field) {
                    case "id":
                        return c2.getId().compareTo(c1.getId());
                    case "name":
                        return c2.getName().compareTo(c1.getName());
                }
            }
            return 0;
        });
        return this.datasource;
    }

    @Override
    public Client getClient(Integer id) {
        Client client = null;
        for (Client c : datasource) {
            if (c.getId().equals(id)) client = c;
        }
        return client;
    }

    @Override
    public void addClient(Client client) {
        this.datasource.add(client);
    }

    @Override
    public void updateClient(Client client) {
        Client c = getClient(client.getId());

        if (c != null) c.setName(client.getName());
    }

    @Override
    public void deleteClient(Integer id) {
        Client c = getClient(id);
        if (c != null) datasource.remove(c);
    }

}
