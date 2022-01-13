package com.javainterview.app.KeyValueStore;

/**
 * Enum of the supported actions
 *
 */
public enum Action {
    SET("SET"),
    UNSET("UNSET");

    public final String label;

    private Action(String label) {
        this.label = label;
    }
}
