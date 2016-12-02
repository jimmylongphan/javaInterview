package com.javainterview.app.stringInterview;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: 336
 * 
 * FIXME TODO
 * 
 * Company: Google, Airbnb
 * 
 * Tags: Hash Table, String, Trie
 * 
 * Given a list of unique words. Find all pairs of distinct indices (i,j)
 * in the given list, so that the concatenation of the two words
 * words[i] + words[j] is a palindrome.
 * 
 * 
 * Example 1:
 *      Given words = ["bat", "tab", "cat"] 
 *      Return [[0, 1], [1, 0]]
 *      The palindromes are ["battab", "tabbat"]
 * 
 * Example 2:
 *      Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 *      Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 *      The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 * 
 * 
 * 
 */
public class PalindromePairs {
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        // base check for null and size
        if (words == null || words.length < 2) {
            return res;
        }
        
        // keep a map of words and their positions in the array
        // key: word
        // val: array position
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        // go through all words
        for (int i=0; i < words.length; i++) {
            // go through all letters in the word 
            for (int j=0; j <= words[i].length(); j++) {
                // substring of left part
                String str1 = words[i].substring(0, j);
                // substring of right part
                String str2 = words[i].substring(j);
                
                // add pair for the left and right parts
                addPair(map, res, str1, str2, i, false);
                if (str2.length() != 0) {
                    // if there is a right part, then create a pair
                    addPair(map, res, str2, str1, i, true);
                }
            }
        }
        return res;
    }
    
    /**
     * 
     * 
     */
    private void addPair(Map<String, Integer> map, List<List<Integer>> res,
        String str1, String str2, int index, boolean reverse) {
        
        // if the first string is a palindrome
        if (isPalindrome(str1)) {
            // reverse the second string
            String str2rev = new StringBuilder(str2).reverse().toString();
            
            // second string reversed exists in the map
            // but it is unique from the current word
            if (map.containsKey(str2rev) && map.get(str2rev) != index) {
                List<Integer> list = new ArrayList<>();
                
                
                if (!reverse) {
                    // add the reversed second word's index to the list
                    list.add(map.get(str2rev));
                    // add the current word's index to the list
                    list.add(index);
                } else {
                    // add the current word's index to the list
                    list.add(index);
                    // add the reversed second word's index to the list
                    list.add(map.get(str2rev));
                }
                // add the list pair to the results
                res.add(list);
            }
        }
    }
    
    /**
     * 
     * @param str string to check if it is a palindrome
     * 
     * Use two indexes and loop left and loop from right
     * If both chars match, then it is palindrome.
     * Any different char is not palindrome.
     */
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left<= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
}