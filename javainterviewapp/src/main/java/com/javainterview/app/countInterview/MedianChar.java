package com.javainterview.app.countInterview;

import java.util.*;

/**
 * Created on 10/6/2015.
 *
 * ['a', 'b', 'b', 'c', 'c', 'e', ??'e', ??'e']
 * [b, c]
 */
public class MedianChar {


    /**
     * Method to get all the median characters of a list
     *
     * @param chars list of chars
     * @return all the median characters
     */
    public Set<Character> getMedianChars(List<Character> chars) {
        Set<Character> result = new HashSet<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // count all the characters
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // get the counts and the median
        List<Integer> counts = new ArrayList<Integer>(map.values());
        Collections.sort(counts);

        // get the median count
        int median = counts.get((counts.size() - 1) / 2);

        // get all characters that have median counts
        for (char c : map.keySet()) {
            if (map.get(c) == median) {
                result.add(c);
            }
        }

        return result;
    }

}
