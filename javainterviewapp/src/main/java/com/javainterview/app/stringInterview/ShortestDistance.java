package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Runtime: O(n + m)
 *
 *
 * Problem 3:
 * New restrictions.
 * word1 and word2 have the same value, but are in different positions
 * in the list.
 */
public class ShortestDistance {

    // key is the word in the list
    // value is the list of positions that contain this word
    private Map<String, List<Integer>> wordMap;

    /**
     * Solves problem 1
     * Use 2 indices to keep track of both words. Then subtract them.
     *
     * @param words list of words
     * @param word1 first word
     * @param word2 second word to find
     * @return the distance
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            // get index of word1
            if (words[i].equals(word1)) {
                index1 = i;
            }

            // get index of word2
            if (words[i].equals(word2)) {
                index2 = i;
            }

            // if we have both indices, then get the distance
            if (index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }

        return distance;
    }


    /**
     * Constructor for shortest distance problem 2
     * The list can contain duplicates.
     * Hash map
     * key: word
     * value: list of indices that contain this word
     *
     * @param words input list
     */
    public ShortestDistance(String[] words) {
        wordMap = new HashMap<String, List<Integer>>();

        // loop through all the words in the map
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // if the map contains this word
            // then add the position of this word to the map
            if (wordMap.containsKey(word)) {
                wordMap.get(word).add(i);
            } else {
                // create new entry in the map
                List<Integer> positionList = new ArrayList<Integer>();
                positionList.add(i);
                wordMap.put(word, positionList);
            }
        }
    }

    /**
     * Default constructor
     */
    public ShortestDistance() {

    }

    /**
     * Solves problem 2
     * There can be duplicates and word1 can match word2
     *
     * @param word1 first to find
     * @param word2 second to find
     * @return distance between words
     */
    public int shortestDistanceOptimum(String word1, String word2) {
        List<Integer> positionsForWord1 = wordMap.get(word1);
        List<Integer> positionsForWord2 = wordMap.get(word2);

        int result = Integer.MAX_VALUE;
        // loop through all positions for the given words
        for (int i = 0, j = 0; i < positionsForWord1.size() && j < positionsForWord2.size(); ) {
            int index1 = positionsForWord1.get(i);
            int index2 = positionsForWord2.get(j);
            // if word1 is before word2
            if (index1 < index2) {
                // then we can get the distance between the two words
                result = Math.min(result, index2 - index1);
                // increment i to see if we can get a closer word1
                i++;
            } else {
                // if word1 is after word2
                // get distance between the words
                result = Math.min(result, index1 - index2);
                // increment word2 to see if we can get a closer word2
                j++;
            }
        }
        return result;
    }


    /**
     * Solves the 3rd problem.
     * word1 and word2 can be the same
     *
     * Idea: if they are the same. Then update index2 to be the current found. Then update index1 to be the
     * previous found, which will be index2.
     *
     * @param words list of input words
     * @param word1 first word
     * @param word2 second word
     * @return distance to find
     */
    public int shortestWordDistanceSame(String[] words, String word1, String word2) {
        long index1 = Integer.MAX_VALUE;
        // index2 will have a negative value
        long index2 = -Integer.MAX_VALUE;
        long distance = Integer.MAX_VALUE;

        boolean same = word1.equals(word2);
        // loop through all words in the list
        for (int i = 0; i < words.length; i++) {
            // found word1
            if (words[i].equals(word1)) {
                // if both words are the same
                // in this algorithm, we will be updating index2 to the found word
                // then update index1 to the last time we saw the word
                if (same) {
                    // index1 will be the previous index we saw the word
                    index1 = index2;
                    // save the index in index2;
                    index2 = i;
                } else {
                    // save index in index1
                    index1 = i;
                }
            } else if (words[i].equals(word2)) {
                // found word2
                index2 = i;
            }
            long tempVal = Math.abs(index1 - index2);
            distance = Math.min(distance, tempVal);
        }
        return (int) distance;
    }


}