package org.arcentales.poointerfaces.model;

public class PremiumClient extends Client implements Comparable<PremiumClient> {
    public PremiumClient(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public int compareTo(PremiumClient o) {
        return getId().compareTo(o.getId());
    }
}
