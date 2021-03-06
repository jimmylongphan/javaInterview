package com.javainterview.app.stringInterview;

/**
 * Given two strings s and t.
 * Return true if they are anagrams of each other.
 * Uses lowercase characters.
 *
 * Solution:
 * O(n) linear
 *
 * Keep an array of ints representing the letters of the alphabet.
 * Loop through the first string and convert to num by subtracting lowercase a.
 * Increment the array tracker with that val.
 *
 * Loop through the second string and convert to int
 * This time we will decrement the array
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // this subtracts the unicode and 
            // we will get the position
            // increment the count at that position
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            // get the position
            // decrement counts
            alphabet[t.charAt(i) - 'a']--;

            // if letters differ, then it will be negative
            if (alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // check all letter counts
        // anagrams should have same number of letters
        // and result in 0
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

}