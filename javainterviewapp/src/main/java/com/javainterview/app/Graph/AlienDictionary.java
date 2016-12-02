package com.javainterview.app.Graph;


import java.util.*;

/**
 * TODO test
 * 
 * LeetCode 269
 * 
 * Company: Google, Airbnb, Facebook, Twitter, Snapchat, Pocket Gems
 * 
 * Tags: Graph, Topological Sort
 * 
 * 
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. 
 * You receive a list of words from the dictionary, 
 * where words are sorted lexicographically by the rules of this 
 * new language. Derive the order of letters in this language.
 * 
 * 
 * For example,
 * Given the following words in dictionary,
 * 
 * [
 *  "wrt",
 *  "wrf",
 *  "er",
 *  "ett",
 *  "rftt"
 * ]
 * 
 * The correct order is: "wertf".
 * 
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, 
 * return any one of them is fine.
 * 
 * 
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        
        String result = "";
        if (words == null || words.length == 0) {
            return result;
        }
        
        // go through all the words
        for (String s : words) {
            // for each letter in the word, assign a default val 0
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        
        // go through all words
        for (int i=0; i < words.length-1; i++) {
            String current = words[i];
            String next = words[i+1];
            
            // take the min length of current or next word
            int length = Math.min(current.length(), next.length());
            
            // consider the case if the first word is longer than
            // the second word, but is sorted first
            if (current.length() > next.length() && 
                current.substring(0,length).equals(next)) {
                return "";
            }
            
            // go through all the letters
            for (int j=0; j < length; j++) {
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                
                // if characters do not match
                if (c1 != c2) {
                    // find the map this c1 contains
                    Set<Character> set = new HashSet<Character>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                    }
                    
                    // add the second character into the map of c1
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        // the character in the second word is 
                        // later in the dictionary
                        // it is heavier
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    // finished for the current 2 words
                    // proceed to next words
                    break;
                }  // end if char
            }  // end for loop char
        }  // end word loop
        
        
        // we have the weights for all the characters
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                // add all the lightest chars
                q.add(c);
            } 
        }
        
        // we now have a set of all the lightest chars 
        while (!q.isEmpty()) {
            char c = q.remove();
            result += c;
            // check if this lightest char has a set
            if (map.containsKey(c)) {
                // loop through all chars in the set
                for (char c2 : map.get(c)) {
                    // decrease the weight of the char
                    degree.put(c2, degree.get(c2) - 1);
                    
                    // once there are no more lighter chars
                    // add it into the queue
                    if (degree.get(c2) == 0) {
                        q.add(c2);
                    }
                }
            }
        }
        
        // if the length of the result does not match
        // degree, then some letters cannot be determined
        if (result.length() != degree.size()) {
            return "";
        }
        
        return result;
    }
}

