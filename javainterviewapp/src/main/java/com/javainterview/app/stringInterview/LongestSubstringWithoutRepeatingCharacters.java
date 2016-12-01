package com.javainterview.app.stringInterview;

import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode 3
 * 
 * Company: Facebook, Amazon, Adobe, Bloomberg, Yelp
 * Tags: Hash Table, Two Pointers, String
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Runtime: O(n) looping through the string
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        // boundary checks
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int length = 0;
        
        // Map of character and current position
        Map<Character, Integer> map = new HashMap<>();
        
        for (int endIndex=0, startIndex=0; endIndex < s.length(); endIndex++) {
            Character c = s.charAt(endIndex);
            // already in the map
            if (map.containsKey(c)) {
                // this endIndex is a duplicate
                // to remove the duplicate from our string we update the start
                // Index
                
                // move the startIndex to the right of its previous location
                // get its location and add 1
                startIndex = Math.max(startIndex, map.get(c) + 1);
            }
            
            // update the current position of the char
            map.put(c, endIndex);
            
            // calculate the length and keep the running maximum
            length = Math.max(length, endIndex - startIndex + 1);
        }
        
        return length;
    }
    
}