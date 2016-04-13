package com.javainterview.app.stringInterview;

/**
 * Company: LinkedIn
 * Tags: String
 * 
 * Problem 1:
 * Given a list of words and two words word1 and word2
 * Return the shortest distance between these two words in the list.
 * 
 * list: ["practice", "makes", "perfect", "coding", "makes"]
 * word1: "coding"
 * word2: "practice"
 * result: 3
 * 
 * word1: "makes"
 * word2: "coding"
 * result: 1
 * 
 * Solution 1:
 * Runtime: O(n)
 * We only need to loop through the list once, but keep the indices of both
 * words. After we find both, then compute the distance.
 * 
 * 
 * Problem 2:
 * New restrictions.
 * Method will be called repeatedly with different parameters.
 * How to optimize it.
 * 
 * Design a class which receives a list of words in the constructor, and 
 * implements a method that takes two words word1 and word2 and
 * Return shortest distance between these two words.
 * 
 */
public class ShortestDistance {
    
    // key is the word in the list
    // value is the list of positions that contain this word
    private Map<String, List<Integer>> wordMap;
    
    
    
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;
        
        for (int i=0; i < words.length(); i++) {
            // get index of word1
            if (words[i].equals(word1)) {
                index1 = i;
            }
            
            // get index of word2
            if (words[i].equals(word2)) {
                index2 = i;
            }
            
            // if we have both indices, then get the distance
            if( index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }
        
        return distance;
    }
    
    
    public wordDistance(String[] words) {
        wordMap = new HashMap<String, List<Integer>>();
        
        // loop through all the words in the map
        for (int i=0; i < words.length(); i++) {
            String word = words[i];
            
            // if the map contains this word
            // then add the position of this word to the map
            if(map.containsKey(w)) {
                map.get(word).add(i);
            } else {
                // create new entry in the map
                List<Integer> positionList = new ArrayList<Integer>();
                positionList.add(i);
                map.put(word, positionList);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> positionsForWord1 = map.get(word1);
        List<Integer> positionsForWord2 = map.get(word2);
        
        int result = Integer.MAX_VALUE;
        for(int i=0, j=0; i < positionsForWord1.size() && j < positionsForWord2.size(); ) {
            
        }
    }
    
    
}