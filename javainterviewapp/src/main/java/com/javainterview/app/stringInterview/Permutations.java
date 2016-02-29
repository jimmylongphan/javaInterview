package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2/28/2016.
 *
 * Idea:  Lets say we have 3 characters in a string.
 * Two get all permutations of the 3 characters, we get permutations of 2 characters.
 * Then we push that 3rd character into every possible spot of 2 characters.
 *
 *
 * O(n!)
 * It is factorial because to get 3 characters, we need 2 characters
 * We need the permutations of the smaller words.
 */
public class Permutations {

    public List<String> getPermutations(String s) {
        // base case
        if (s == null) {
            return null;
        }

        List<String> permutations = new ArrayList<String>();

        // base case
        if (s.length() == 0) {
            permutations.add("");
            return permutations;
        }

        // get the first character
        char first = s.charAt(0);

        // get the remaining string at index 1
        String remainder = s.substring(1);

        // recursively generate the permutations for the smaller strings
        // This is the factorial portion of the algorithm
        List<String> words = getPermutations(remainder);

        // for each of the smaller words
        for (String word : words) {
            // for all characters in the smaller word
            for (int j=0; j <= word.length(); j++) {
                // we insert the first character into every possible slot in the word
                String temp = insertCharAt(word, first, j);
                permutations.add(temp);
            }
        }
        return permutations;
    }

    /**
     * Insert the character in the given word at position i
     *
     * @param word source word
     * @param c character to insert
     * @param i position of character
     * @return new string
     */
    protected String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }



}
