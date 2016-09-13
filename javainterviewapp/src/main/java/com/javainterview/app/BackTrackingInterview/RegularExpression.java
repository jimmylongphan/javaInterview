package com.javainterview.app.BackTrackingInterview;

// TODO test

/**
 * LeetCode 10
 * 
 * Fitbit on Thursday 9/8
 * Google, Uber, Airbnb, Facebook, Twitter
 * 
 * Dynamic Programming, Backtracking, String
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * Return true if the input string matches the pattern.
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Solution {
    
    /**
     * 
     * @param s String to check
     * @param p Pattern to compare
     * 
     */
    public boolean isMatch(String s, String p) {
        // if either string is null, then no match
        if (s == null || p == null) {
            return false;
        }
        
        // Keep a 2 dimensional array where we check for every length of the 
        // pattern and string matches
        // Final solution is where all of string is true and all of p is true
        // dp[String matches][pattern matches]
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        // initialize the first character and pattern as matching true
        dp[0][0] = true;
        
        // loop through all characters in pattern
        // Edge case where we are matching the first character in the string
        // String = 'aaaa'
        // Pattern = '**'
        for (int i = 0; i < p.length(); i++) {
            // if the current pattern is a star
            // And the previous pattern matches the string,
            // The i-1 is ok because the very first char in pattern will not be *
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                // Then the next pattern match is true
                dp[0][i+1] = true;
            }
        }
        
        // NOTE
        // Reason setting i+1, j+1 to i,j is because i,j should be true
        // If i,j is not true, then current and future indicies will be false.
        
        // loop through all characters in the input string
        for (int i = 0 ; i < s.length(); i++) {
            // loop through all characters in the pattern
            for (int j = 0; j < p.length(); j++) {
                // if the pattern is a '.'
                if (p.charAt(j) == '.') {
                    // The next string and pattern match equals 
                    // the current string and pattern match
                    dp[i+1][j+1] = dp[i][j];
                }
                
                // if both pattern and char matches
                if (p.charAt(j) == s.charAt(i)) {
                    // set to true the next indices
                    dp[i+1][j+1] = dp[i][j];
                }
                
                // if the current pattern is a char
                if (p.charAt(j) == '*') {
                    // if the previous pattern does not match the current char
                    // AND the previous pattern is not a '.'
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        // next indices equal the next char and previous pattern
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        // next indicies equal
                        // next char and current pattern
                        // OR current char and next pattern
                        // OR next char and previous pattern
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        
        // The entire string and pattern matches
        return dp[s.length()][p.length()];
    }
}
