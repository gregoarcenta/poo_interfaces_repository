package org.arcentales.poointerfaces.model;

public class BaseEntity {
    private static int lastId;
    private Integer id;

    public BaseEntity() {
        this.id = ++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
