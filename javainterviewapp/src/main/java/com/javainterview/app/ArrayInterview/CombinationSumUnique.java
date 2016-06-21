package com.javainterview.app.ArrayInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/2/2016.
 * 
 * LeetCode 40
 * Company: Snapchat, Uber
 * Tags: Array, Backtracking
 * 
 * Given a collection C and target T, find all combinations that sum to T.
 * Numbers in each combo can be used only once.
 *
 * Runtime: O(n!)
 *   Each recursive call is 1 less than previous
 *
 */
public class CombinationSumUnique {

    /**
     * Method to find all combinations that add up to target
     * @param numbers list of all numbers
     * @param target sum to find
     * @return list of results
     */
    public List<List<Integer>> combinationSum(int[] numbers, int target) {
        // sort all the numbers in the list
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();

        getResult(result, path, numbers, target, 0);

        return result;
    }

    /**
     * Recursive method to find all combinations that will add up to the desired target
     *
     * @param result store all results
     * @param currentCombo current combination to test
     * @param numbers source of numbers
     * @param target current sum to add
     * @param start index in the numbers array to start
     */
    protected void getResult(List<List<Integer>> result, List<Integer> currentCombo, int[] numbers, int target, int start) {
        // our target is positive
        if (target > 0) {
            // loop through from start position to the end of the list of numbers
            // loop as long as the target is greater than the value in current index
            for (int i=start; i < numbers.length && target >= numbers[i]; i++) {
                // prevent duplicates
                if ( i > start && numbers[i] == numbers[i-1]) {
                    // numbers in the array are duplicates
                    continue;
                }

                // add the number at index to our current combo
                currentCombo.add(numbers[i]);

                // recursively find a combo using the current combo with the newly added number
                // start at the next index i+1, do not reuse the current index
                getResult(result, currentCombo, numbers, target - numbers[i], i+1);

                // no longer using the currentCombo with the current number
                // remove the last element
                currentCombo.remove(currentCombo.size()-1);
            }
        } else if (target == 0) {
            // reached the desired sum, add the combo to the result
            result.add(new ArrayList<Integer>(currentCombo));
        }
    }
}
