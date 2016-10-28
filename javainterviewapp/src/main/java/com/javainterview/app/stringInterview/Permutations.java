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
 *
 *
 * Permute strings
 * Idea:  Lets say we have 3 characters in a string.
 * Two get all permutations of the 3 characters, we get permutations of 2 characters.
 * Then we push that 3rd character into every possible spot of 2 characters.
 *
 *
 * O(n!)
 * It is factorial because to get 3 characters, we need 2 characters
 * We need the permutations of the smaller words.
 *
 * Divide and Conquer
 * Backtracking
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
     * @param begin position in the num array
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

    /**
     * recursive solution
     *
     * @param s String to permute
     * @return List of all permuted strings
     */
    public List<String> permuteString(String s) {
        if (s == null) {
            return null;
        }

        List<String> permutations = new ArrayList<>();

        // base case where string is empty
        if (s.isEmpty()) {
            permutations.add("");
            return permutations;
        }

        // get the first char to insert at different positions
        char first = s.charAt(0);

        // get the remaining substring
        String remainder = s.substring(1);

        // recursively get the permutations of the smaller strings
        List<String> permutedSubstrings = permuteString(remainder);

        // go through all of the smaller permutations
        for (String substring : permutedSubstrings) {
            // for every index in the substring
            for (int j=0; j <= substring.length(); j++) {
                // insert the first char at this index
                String temp = insertCharAt(substring, first, j);
                permutations.add(temp);
            }
        }

        return permutations;
    }

    /**
     * Build a new string with the character at position
     * @param s original string
     * @param c char to add
     * @param index position to add
     * @return the newly built string
     */
    public String insertCharAt(String s, char c, int index) {
        String prefix = s.substring(0, index);
        String suffix = s.substring(index);
        return prefix + c + suffix;
    }


}
