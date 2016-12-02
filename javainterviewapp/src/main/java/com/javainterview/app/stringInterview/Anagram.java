package com.javainterview.app.stringInterview;

import java.util.Arrays;

/**
 * Concrete implementation for the comparable class
 * Is used for Priority Queue interface
 */
public class Anagram implements Comparable<Anagram> {
    public String key;
    public String value;

    public Anagram(String s) {
        // save the val
        this.value = s;

        // generate the key
        char[] array = s.toCharArray();
        Arrays.sort(array);
        key = new String(array);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * This is the implemented methods
     * Reuse the string compareTo method on the key, since that is defining the anagram
     */
    public int compareTo(Anagram o) {
        String key2 = o.getKey();

        return key.compareTo(key2);
    }

}