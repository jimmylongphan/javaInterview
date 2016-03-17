package com.javainterview.app.stringInterview;


/**
 * Given a String S, you can add characters to the front.
 * Find and return the shortest palindrome you can find.
 * 
 * "abcd" -> "dcbabcd"
 * 
 * Execution stack
 *   "abcd" -> a matches a, beginIndex = 1.  Reverse = "dcb" Suffix = "bcd", sub = "a"
 *   "dcb" + "a" + "bcd" -> all match
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
        for (endIndex = s.length() - 1; endIndex >=0; endIndex--) {
            // if characters match
            // move beginIndex towards middle
            if (s.charAt(endIndex) == s.charAt(beginIndex)) {
                beginIndex++;
            }
        }
        
        // At this point, the beginIndex should point to a location
        // where we can build a palindrome
        if (beginIndex == s.length) {
            // already a palindrome
            return s;
        }
        
        // Get the characters that we will need to add to the beginning
        String suffix = s.substring(beginIndex);
        String reverse = suffix.reverse();

        String result = reverse + shortestPalindrome(s.substring(0,beginIndex)) + suffix;
        return result;
    }
    
}