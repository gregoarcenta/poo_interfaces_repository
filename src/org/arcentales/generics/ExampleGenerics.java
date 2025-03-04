package org.arcentales.generics;

import org.arcentales.poointerfaces.model.Client;
import org.arcentales.poointerfaces.model.PremiumClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExampleGenerics {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Alex"));
        clients.add(new Client("Elsa"));
        System.out.println(clients.getFirst());

        Client[] clientsArr = {
                new Client("Gregory"), new Client("Fernanda")
        };
        Integer[] integersArr = {1, 2, 3};

        List<Client> clients2 = fromArrayToList(clientsArr);
        List<Integer> integers = fromArrayToList(integersArr);

        clients2.forEach(System.out::println);
        integers.forEach(System.out::println);

        List<PremiumClient> premiumClients = fromArrayToList(new PremiumClient[]{
                new PremiumClient("Zamira"),
                new PremiumClient("Axel"),
                });

        premiumClients.sort(Comparator.comparing(PremiumClient::getName));
        premiumClients.forEach(System.out::println);
    }

    public static <T> List<T> fromArrayToList(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T extends Client & Comparable<T>> List<T> fromArrayToList(T[] arr) {
        return Arrays.asList(arr);
    }
}
