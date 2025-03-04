package org.arcentales.poointerfaces;

import org.arcentales.poointerfaces.model.Client;
import org.arcentales.poointerfaces.repository.ClientRepository;
import org.arcentales.poointerfaces.repository.Direction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();

        System.out.println("========== Clients =============");
        clientRepository.create(new Client("Alex"));
        clientRepository.create(new Client("Gregory"));
        clientRepository.create(new Client("Elsa"));
        clientRepository.create(new Client("Jennifer"));
        clientRepository.create(new Client("Lucia"));

        List<Client> clients = clientRepository.getAll();
        clients.forEach(System.out::println);

        System.out.println("\n========== Clients Paginated =============");
        clients = clientRepository.getAll(2, 5);
        clients.forEach(System.out::println);

        System.out.println("\n========== Client By ID=============");
        Client client = clientRepository.getById(3);
        System.out.println(client);

        System.out.println("\n========== Update Client =============");
        Client newClient = new Client("Zamira");
        newClient.setId(3);
        clientRepository.update(newClient);
        System.out.println(clientRepository.getById(3));

        System.out.println("\n========== Removed Client =============");
        System.out.println(clientRepository.getById(2) + " removed");
        clientRepository.remove(2);

        System.out.println("\n========== Clients Ordered =============");
        clients = clientRepository.getAll("name", Direction.DESC);
        clients.forEach(System.out::println);

    }
}