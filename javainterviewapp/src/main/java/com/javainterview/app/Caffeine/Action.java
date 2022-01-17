package com.javainterview.app.Caffeine;

public enum Action {
    SET("SET"),
    GET("GET"),
    UNSET("UNSET");

    public final String label;

    private Action(String label) {
        this.label = label;
    }
}
