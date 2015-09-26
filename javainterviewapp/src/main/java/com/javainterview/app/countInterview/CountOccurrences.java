package com.javainterview.app.countInterview;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

/**
 * Given an array of Integers, determine if there exists
 * at least x occurrences of a number.
 * T: O(n)
 * S: O(n)
 *
 * Assume proper values for count such as greater than 1.
 */
public class CountOccurrences {
    
    public boolean hasNOccurrences( int[] array, int count ) {
        int length = array.length;
        
        if (length < count) {
            return false;
        }
        
        Map<Integer, Integer> countTracker = new HashMap<Integer, Integer>();
        for (int num : array) {
            if (countTracker.containsKey(num)) {
                int val = countTracker.get(num) + 1;
                if (val >= count) {
                    return true;
                } else {
                    countTracker.put(num, val);
                }
            } else {
                countTracker.put(num, 1);
            }
        }
        return false;
    }
}

