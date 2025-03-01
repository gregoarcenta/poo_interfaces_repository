package org.arcentales.interfaces;

import org.arcentales.interfaces.model.Client;
import org.arcentales.interfaces.repository.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CrudRepository clientRepository = new ClientRepository();

        System.out.println("========== Clients =============");
        clientRepository.addClient(new Client("Alex"));
        clientRepository.addClient(new Client("Gregory"));
        clientRepository.addClient(new Client("Elsa"));
        clientRepository.addClient(new Client("Jennifer"));
        clientRepository.addClient(new Client("Lucia"));

        List<Client> clients = clientRepository.getClients();
        clients.forEach(System.out::println);

        System.out.println("\n========== Clients Paginated =============");
        clients = ((PaginableRepository) clientRepository).getClients(2, 5);
        clients.forEach(System.out::println);

        System.out.println("\n========== Client By ID=============");
        Client client = clientRepository.getClient(3);
        System.out.println(client);

        System.out.println("\n========== Update Client =============");
        Client newClient = new Client("Zamira");
        newClient.setId(3);
        clientRepository.updateClient(newClient);
        System.out.println(clientRepository.getClient(3));

        System.out.println("\n========== Removed Client =============");
        System.out.println(clientRepository.getClient(2) + " removed");
        clientRepository.deleteClient(2);

        System.out.println("\n========== Clients Ordered =============");
        clients = ((OrdenableRepository) clientRepository).getClients("name", Direction.DESC);
        clients.forEach(System.out::println);

    }
}