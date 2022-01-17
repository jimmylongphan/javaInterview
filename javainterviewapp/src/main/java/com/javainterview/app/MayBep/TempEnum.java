package com.javainterview.app.MayBep;

/**
 * Created on 1/16/2022.
 */
public enum TempEnum {
    ANY("ANY"),
    HOT("HOT"),
    COLD("COLD"),
    FROZEN("FROZEN");

    public final String label;

    private TempEnum(String label) {
        this.label = label;
    }
}
