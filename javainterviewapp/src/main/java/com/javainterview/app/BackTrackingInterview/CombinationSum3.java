package com.javainterview.app.BackTrackingInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 216
 *
 * Find all possible combinations of k numbers that add up to a number n.
 * Given only numbers 1-9 are used.
 * Each set is unique.
 *
 * Created on 12/26/2016.
 *
 * Tags: Array, Backtracking
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]
 *
 * Example 2:
 * Input:
 *  k = 3, n = 9
 * Output:
 *  [[1,2,6], [1,3,5], [2,3,4]]
 *
 *  Runtime: O(n!)
 *  In this case is O( n * (n-1) * (n-2) )
 */
public class CombinationSum3 {
    /**
     * @param k amount of numbers to use
     * @param n target value
     * @return list of lists that add up to n
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();

        combinationSum3Helper(result, new LinkedList<>(), 1, k, n);

        return result;
    }

    /**
     * @param result  backtracking values
     * @param current the picked value
     * @param index   the current used value in our list
     * @param k       numbers left to use
     * @param n       target value
     */
    private void combinationSum3Helper(List<List<Integer>> result, LinkedList<Integer> current, int index, int k, int n) {
        // base case we are done with this path
        if (k == 0 && n == 0) {
            result.add(new LinkedList<>(current));
            return;
        }

        // error check recursive paths
        if (k < 0 || n < 0) {
            // cannot continue if we have used up all number and cannot sum to the target n
            return;
        }

        // iterate through all combinations
        for (int i = index; i <= 9; i++) {
            // choose a current value
            current.add(i);

            // recursive call with the current value
            // update the new index value because we picked the current one
            // subtract k because we used up a number
            // update our target value by subtracting the picked value
            combinationSum3Helper(result, current, i + 1, k - 1, n - i);

            // remove the chosen value
            current.remove(current.size() - 1);
        }
    }


}
