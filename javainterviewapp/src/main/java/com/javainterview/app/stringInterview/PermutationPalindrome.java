package com.javainterview.app.stringInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 11/16/2019.
 */
public class PermutationPalindrome {

    // check if the string is a permutation of a palindrome
    public static boolean hasPalindromePermutation(String theString) {

        Map<Character, Integer> counts = new HashMap<>();
        // generate the counts of the characters
        for (char c : theString.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }

        // check if it is a palindrome
        // only 1 element should have a value of 1 if it is odd
        // if it is even, then all values should be 2
        boolean shouldHaveOne = false;
        if (theString.length() % 2 == 1) {
            // odd length
            shouldHaveOne = true;
        }

        for ( int count : counts.values()) {
            if (shouldHaveOne) {
                if (count % 2 == 1) {
                    shouldHaveOne = false;
                }
            } else {
                if (count % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
