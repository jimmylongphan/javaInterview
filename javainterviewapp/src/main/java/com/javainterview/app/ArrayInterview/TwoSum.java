package com.javainterview.app.ArrayInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 1
 * Company: Google, Uber, Apple, LinkedIn
 * Tags: Array, HashTable
 * 
 * Created on 1/16/2016.
 *
 * Given an array. Find two numbers that add up to a sum.
 * Return the indices of the numbers.
 * Assume only one solution or pair.
 * Based 1 index.
 * That is why they are adding the +1.
 * If it is based 0, then they do not need to add +1.
 *
 * Solution:
 * The result map contains the indices of the two numbers.
 * Idea
 * We loop through the array.
 * We subtract the sum from the current number and index.
 * The difference can exist in the array.
 *
 * If the difference exists in the array, we are done.
 * If it is not, then we store the key and the index.
 *
 *
 */
public class TwoSum {

    public Integer[] twoSum(int[] numbers, int sum) {
        Integer[] result = new Integer[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // loop through all elements
        for (int i=0; i < numbers.length; i++) {
            // for each element in the array
            // check if map contains the difference
            int difference = sum - numbers[i];
            if (map.containsKey(difference)) {
                // if it contains the other number
                // store the index of this number
                result[1] = i + 1;

                // store the index of the other number
                result[0] = map.get(difference);
                return result;
            }

            // result not found
            // store the number and the its index
            map.put(numbers[i], i+1);
        }

        return result;
    }
}
