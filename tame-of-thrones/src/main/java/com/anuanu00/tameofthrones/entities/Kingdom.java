package com.anuanu00.tameofthrones.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

@EqualsAndHashCode
public abstract class Kingdom {
    @Getter
    protected final String name;
    @Getter
    protected final String emblem;
    protected final Set<Kingdom> allies;

    protected Kingdom(String name, String emblem, Set<Kingdom> allies) {
        this.name = name;
        this.emblem = emblem;
        this.allies = allies;
        validateAlly();
    }

    public Set<Kingdom> getAlly() {
        return new LinkedHashSet<>(allies);
    }

    public void addAlly(Kingdom kingdom) {
        if (!kingdom.equals(this) && !allies.contains(kingdom)) {
            kingdom.addAlly(this);
            allies.add(kingdom);
        }
    }

    public void removeAlly(Kingdom kingdom) {
        if (allies.contains(kingdom)) {
            kingdom.removeAlly(this);
            allies.remove(kingdom);
        }
    }

    private void validateAlly() {
        if (!allies.contains(this)) {
            allies.remove(this);
        }

        allies.stream().forEach(ally -> ally.addAlly(this));
    }

}
