package com.javainterview.app.ArrayInterview;

/**
 * Created on 9/26/2015.
 * From Apple
 * <p>
 * Problem
 * There is a v shape array
 * Find the smallest element in the array
 */
public class VShape {
    /**
     * Runtime O(n)
     * Space O(0)
     */
    public int findMin(int[] a) {
        int min = a[0];

        if (a.length == 1) {
            return min;
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else {
                // once the elements become larger, then we know we hit bottom
                // return the smallest value
                break;
            }
        }

        return min;
    }
}
