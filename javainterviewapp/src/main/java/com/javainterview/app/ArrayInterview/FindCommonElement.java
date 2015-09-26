package com.javainterview.app.ArrayInterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 9/26/2015.
 * Problem
 * Find the common elements between two integer arrays.
 */
public class FindCommonElement {

    /**
     * Method to find the common elements between two arrays
     * Uses sort which is n log n, and space to list common elements
     * <p>
     * Space O(n)
     * Runtime O(n log n)
     */
    public Set<Integer> findCommonElement(int[] a1, int[] a2) {
        // space O(n)
        Set<Integer> commonElements = new HashSet<Integer>();

        // sort the arrays if not already sorted
        // O (n log n)
        Arrays.sort(a1);
        Arrays.sort(a2);

        int index1 = 0, index2 = 0;
        int val1, val2;

        // looping through the end for both sorted arrays
        // If an element matches then add that to the set
        // If not, then increment the index of the smaller values
        while (index1 < a1.length && index2 < a2.length) {
            val1 = a1[index1];
            val2 = a2[index2];

            if (val1 == val2) {
                commonElements.add(val1);
                index1++;
                index2++;
            } else if (val1 < val2) {
                index1++;
            } else {
                index2++;
            }
        }

        return commonElements;
    }


    /**
     * Method to find if common element exists
     * If not using sorting, then we need to check all elements, which is more runtime
     * <p>
     * Space: O(0)
     * Runtime: O(n^2)
     */
    public boolean findIfCommon(int[] a1, int[] a2) {
        int index1 = 0, index2 = 0;
        int val1, val2;

        for (int i : a1) {
            for (int j : a2) {
                if (i == j) {
                    return true;
                }
            }
        }

        return false;
    }
}
