package org.arcentales.poointerfaces.model;

public class PremiumClient extends Client implements Comparable<PremiumClient> {
    public PremiumClient(String name) {
        super(name);
    }

    @Override
    public int compareTo(PremiumClient o) {
        return getId().compareTo(o.getId());
    }
}
