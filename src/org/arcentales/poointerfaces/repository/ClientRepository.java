package org.arcentales.poointerfaces.repository;

import org.arcentales.poointerfaces.model.Client;
import org.arcentales.poointerfaces.repository.exceptions.ReadAccessDataException;

import java.util.List;

public class ClientRepository extends AbstractCrudRepository<Client> {

    @Override
    public void update(Client client) throws ReadAccessDataException {
        Client c = getById(client.getId());

        if (c != null) {
            c.setName(client.getName());
            c.setLastName(client.getLastName());
        }
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
