package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 139
 * 
 * Created on 3/20/2016.
 *
 * Tags: Dynamic Programming
 * Company: Google, Uber, Facebook, Amazon, Yahoo
 * 
 * Given a string s and dictionary of words.
 * Determine if s can be segmented into a space
 * separated sequence of one or more dictionary words.
 * 
 * runtime: O(n^2)
 * but second loop is shorter so O(n * wordLength)
 * ------------------------------------
 * 
 * LeetCode 140
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word
 * is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * Tags: Dynamic Programming, Backtracking
 * Company: Dropbox, Google, Uber, Snapchat, Twitter
 *
 */
public class WordBreak {

    /**
     * LeetCode 139
     * 
     */
    public boolean wordBreak(String s, Set<String> dictionary) {
        List<String> result = new ArrayList<String>();

        // keep track of whether all positions can be broken
        // add an extra 1 because the substring method is exclusive
        boolean[] breakable = new boolean[s.length() + 1];

        // starting position is breakable
        breakable[0] = true;

        // loop through all indices starting from index 1
        // substring is exclusive
        for (int endIndex = 1; endIndex < s.length() + 1; endIndex++) {
            // start at index 0 and end at at the end index
            for (int beginIndex = 0; beginIndex < endIndex; beginIndex++) {
                String sub = s.substring(beginIndex, endIndex);
                if (breakable[beginIndex] && dictionary.contains(sub)) {
                    breakable[endIndex] = true;
                    result.add(sub);
                    break;
                }
            }
        }

        // this shows all characters are breakable
        // off by 1 - accessing the very last index
        if (breakable[s.length()]) {
            return result;
        }

        return false;
    }

    /**
     * LeetCode 140
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return wordBreakHelper(s, wordDict, map);
    }
    
    public List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        // base condition
        // we already processed this word
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> result = new LinkedList<String>();
        
        // reached the end of the input string
        if (s.length() == 0) {
            // add an empty string to the end
            result.add("");
            // return our result
            return result;
        }
        
        // loop through all the words in the dictionary
        for (String word : wordDict) {
            // check if our input starts with a dictionary word
            if (s.startsWith(word)) {
                // create a new input string without the starting word
                String s2 = s.substring(word.length());
                
                // get results with the smaller input string
                List<String> subList = wordBreakHelper(s2, wordDict, map);
                
                for (String sub : subList) {
                    // if this a word in between, then add a space
                    // if it is the last word, then no space
                    String space = sub.isEmpty() ? "" : " ";
                    
                    // create our result using the given word
                    // and DFS words
                    result.add(word + space + sub);
                }
            }

        }
        // for the given input, save the results
        map.put(s, result);
        return result;
    }
    
}
