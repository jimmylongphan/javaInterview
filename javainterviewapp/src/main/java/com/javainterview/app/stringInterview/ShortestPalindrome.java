package com.javainterview.app.stringInterview;


/**
 * Given a String S, you can add characters to the front.
 * Find and return the shortest palindrome you can find.
 *
 * "abcd" -> "dcbabcd"
 *
 * Execution stack
 * "abcd" -> a matches a, beginIndex = 1.  Reverse = "dcb" Suffix = "bcd", sub = "a"
 * "dcb" + "a" + "bcd" -> all match
 *
 *
 * "aaba" -> reverse = "ab" suffix = "ba" sub = "aa"
 * "ab" + "aa" + "ba" -> all match
 *
 * "aab" -> reverse = "b" suffix = "b" sub = "aa"
 * "b" + "aa" + "b" -> all match
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int beginIndex = 0;
        // compare the end of the string with the beginning
        // We are starting with the end because we are adding characters
        // to the beginning
        for (int endIndex = s.length() - 1; endIndex >= 0; endIndex--) {
            char beginChar = s.charAt(beginIndex);
            char endChar = s.charAt(endIndex);

            // if characters match
            // move beginIndex towards middle
            if (endChar == beginChar) {
                beginIndex++;
            }
        }

        // At this point, the beginIndex should point to a location
        // where we can build a palindrome
        if (beginIndex == s.length()) {
            // already a palindrome
            return s;
        }

        // Get the characters that we will need to add to the beginning
        String suffix = s.substring(beginIndex);
        String reverse = new StringBuilder(suffix).reverse().toString();

        String result = reverse + shortestPalindrome(s.substring(0, beginIndex)) + suffix;
        return result;
    }

}