package com.javainterview.app.stringInterview;

public class AnagramImpl implements Anagram<Anagram>  {
    public String value;

    public AnagramImpl(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }

    public int compareTo(Anagram o) {
        return value.compareTo(o.getValue());
    }
    
}