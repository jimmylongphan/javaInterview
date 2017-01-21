package com.javainterview.app.BackTrackingInterview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 78
 * 
 * Company: Amazon, Uber, Facebook
 * Tags: Array, Backtracking, Bit Manipulation
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * 
 * If nums = [1,2,3], a solution is
 * 
 * Runtime: O(n!)
 * Factorial because the next step in recursion the size
 * is always one smaller.
 * 
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // call backtracking with our result, current list, input, and starting index
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // add the current list into our result
        result.add(new ArrayList<>(tempList));

        // loop through the rest of the nums
        for (int i = start; i < nums.length; i++) {
            // add this num to our temporary list
            tempList.add(nums[i]);

            // continue building the subsets with the current list
            // and the next number
            backtrack(result, tempList, nums, i + 1);

            // remove the chosen value from our list
            // whenever backtrack returns, the latest value is 
            // always removed
            tempList.remove(tempList.size() - 1);
        }
    }

}