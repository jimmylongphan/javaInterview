package com.javainterview.app.ArrayInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 9/27/2015.
 *
 * Check if one array is a subset of another.
 * All elements in a1 must be in a2.
 */
public class ArraySubset {

    /**
     * This method will check if all the elements in a1 is in a2.
     */
    public boolean isSubset(int[] a1, int[] a2) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        // load all values in a2 into counts
        for (int i = 0; i < a2.length; i++) {
            if (counts.containsKey(a2[i])) {
                counts.put(a2[i], counts.get(a2[i]) + 1);
            } else {
                counts.put(a2[i], 1);
            }
        }

        for (int i : a1) {
            // if any element in a2 is missing
            // return false
            if (!counts.containsKey(i)) {
                return false;
            } else {
                // decrement the counter
                int count = counts.get(i) - 1;
                counts.put(i, count);

                // once all elements are found, then remove
                if (count == 0) {
                    counts.remove(i);
                }
            }
        }

        return true;
    }
}
