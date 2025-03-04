package org.arcentales.poointerfaces.repository;

import org.arcentales.poointerfaces.model.Client;

import java.util.List;

public class ClientRepository extends AbstractCrudRepository<Client> {

    @Override
    public Client getById(Integer id) {
        Client client = null;
        for (Client c : datasource) {
            if (c.getId().equals(id)) client = c;
        }
        return client;
    }

    @Override
    public void update(Client client) {
        Client c = getById(client.getId());

        if (c != null) c.setName(client.getName());
    }

    @Override
    public List<Client> getAll(String field, Direction dir) {
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
}
