package org.arcentales.interfaces.model;

import java.util.Objects;

public class Client {
    private static int lasId;
    private Integer id;
    private String name;

    public Client() {
        this.id = ++lasId;
    }

    public Client(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals: " + o);
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
