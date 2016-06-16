package com.javainterview.app.ArrayInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 4/3/2016.
 *
 * Problem:
 * Company Facebook:
 *
 * Similar to combination sum but it includes positive and negative integers.
 * Since if there are negative integers we may run into infinite loops.
 * For example {-1, 100}
 *   If we can use duplicates, then we can use -1... a hundred times and 100.
 *
 * To limit this, we will only accept a k amount of integers in the combination.
 *
 * 
 * Solutions:
 * http://www.sigmainfy.com/blog/k-sum-problem-analysis-recursive-implementation-lower-bound.html
 * http://rafal.io/posts/k-numbers-sum-to-c.html
 * 
 */
public class KSum {

    /**
     * Public method to get all numbers that sum to the target.
     * Includes negative numbers
     *
     * @param numbers
     * @param target
     * @return
     */
    public List<List<Integer>> kSum( int[] numbers, int k, int target ) {
        // sort all of the numbers in the list
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();

        // getting result with all the numbers, the target, and a fresh starting index of 0
        getResultAll(result, combo, numbers, k, target, 0);

        return result;
    }

    /**
     * Modification of previous function.
     * This time we will handle positive and negative numbers.
     *
     * @param result
     * @param currentCombo
     * @param numbers
     * @param k the size of the combination
     * @param target
     * @param start
     */
    protected void getResultAll(List<List<Integer>> result, List<Integer> currentCombo, int[] numbers, int k, int target, int start) {
        // boundary checks
        if (currentCombo.size() > k) {
            return;
        }

        // calculate the currentSum
        int currentSum = 0;
        for( int num : currentCombo ) {
            currentSum += num;
        }

        // Since the target can be any value, we must check if we have any combinations
        // If the combo is empty, then we must look for values
        // Our target can be positive or negative, but we must find numbers until we reach our target
        if (currentSum != target || currentCombo.isEmpty()) {
            // loop through from start position to the end of the list of numbers
            // only loop as long as the target is greater than the value in the current index
            for (int i=start; i < numbers.length; i++) {
                // add the number at index to our current list
                // Try the combination with the current i
                currentCombo.add(numbers[i]);

                getResultAll(result, currentCombo, numbers, k, target, i);

                // no longer trying the combination with i
                // remove the i value from the list, or the last item
                currentCombo.remove(currentCombo.size()-1);
            }
        } else if (currentSum == target && currentCombo.size() == k) {
            // satisfied the sum, add the current list into the result
            result.add(new ArrayList<Integer>(currentCombo));
        }
    }
}
