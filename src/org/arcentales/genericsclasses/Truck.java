package org.arcentales.genericsclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Truck<T> implements Iterable<T> {
    private final int max;
    private final List<T> objects;

    public Truck(int max) {
        this.max = max;
        this.objects = new ArrayList<>();
    }

    public void add(T object) {
        if (objects.size() <= max) {
            this.objects.add(object);
        } else {
            throw new RuntimeException("don't have more than " + max + " objects");
        }
    }

    @Override
    public Iterator iterator() {
        return this.objects.iterator();
    }
}
