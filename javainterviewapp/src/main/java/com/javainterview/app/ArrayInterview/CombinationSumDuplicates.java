package com.javainterview.app.ArrayInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/1/2016.
 * Leetcode 39
 * Company: Snapchat, Uber
 * Tags: Array, Backtracking
 * 
 * Given a unique set of numbers C and a target number T.
 * Find all unique combinations in C where they sum to T
 *
 * Note: We can use duplicate numbers
 *
 * Runtime: O(n!)
 */
public class CombinationSumDuplicates {

    /**
     * Method to find all combinations that add up to target
     * @param numbers list of all numbers
     * @param target the sum to get
     * @return list of lists
     */
    public List<List<Integer>> combinationSum( int[] numbers, int target ) {
        // sort all of the numbers in the list
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        // getting result with all the numbers, the target, and a fresh starting index of 0
        getResult(result, path, numbers, target, 0);

        return result;
    }

    /**
     *
     *
     * @param result Keep track of all combinations
     * @param currentCombo the current combination
     * @param numbers list of all numbers to choose from
     * @param target sum to find
     * @param start position in numbers array to start
     */
    protected void getResult(List<List<Integer>> result, List<Integer> currentCombo, int[] numbers, int target, int start) {
        // our target is a positive
        if (target > 0) {
            // loop through from start position to the end of the list of numbers
            // only loop as long as the target is greater than the value in the current index
            for (int i=start; i < numbers.length && target >= numbers[i]; i++) {
                // add the number at index to our current list
                // Try the combination with the current i
                currentCombo.add(numbers[i]);

                // get results with the current number and number subtracted from target
                // start at index i
                // get the rest of the combination while using this current value
                // Subtract the current number from the target and try to retrieve the other numbers
                getResult(result, currentCombo, numbers, target - numbers[i], i);

                // no longer trying the combination with i
                // remove the i value from the list, or the last item
                currentCombo.remove(currentCombo.size()-1);
            }
        } else if (target == 0) {
            // satisfied the sum, add the current list into the result
            result.add(new ArrayList<Integer>(currentCombo));
        }
    }
}
