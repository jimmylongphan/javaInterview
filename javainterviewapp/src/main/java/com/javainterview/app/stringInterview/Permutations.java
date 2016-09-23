package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 46
 * Company: LinkedIn, Microsoft
 * Tags: Backtracking
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * [1,2,3]
 * 
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    /**
     * Public caller method
     * @param nums array to generate permutations
     * @return list of permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums, 0, result);
        return result;
    }
    
    /**
     * Use DFS to generate permutations
     * 
     * @param num
     * @param beginning position in the num array
     * @param result list of permutations
     */
    public void permute(int[] num, int begin, List<List<Integer>> result) {
        // base case to return
        // we reached the length of num so this is a complete permutation
        if (begin >= num.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i=0; i < num.length; i++) {
                list.add(num[i]);
            }
            result.add(list);
            return;
        }
        
        // permute starting at begin position and loop to end
        for (int i=begin; i < num.length; i++) {
            // swap position with i
            swap(begin, i, num);
            
            // recursively permute
            permute(num, begin+1, result);
            
            // undo swap
            swap(begin, i, num);
        }
    }
    
    /**
     * Primitives are pass by value
     * The array will store the swapped results
     * 
     * @param pos1 position first num to swap
     * @param pos2 position second num to swap
     * @param num array to swap
     * 
     */
    public void swap (int pos1, int pos2, int[] num) {
        int temp = num[pos1];
        num[pos1] = num[pos2];
        num[pos2] = temp;
    }
}
