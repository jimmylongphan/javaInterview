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

        int oddCounts = 0;
        for (int count : counts.values()) {
            // if odd, then update oddcounts
            if (count % 2 == 1) {
                oddCounts++;
            }
            // if there are more than 1 oddCount, then is not a palindrome
            if (oddCounts > 1) {
                return false;
            }
        }
        return true;
    }

}
