package com.javainterview.app.ArrayInterview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode: 15
 * Company: Amazon, Microsoft, Bloomberg, Facebook, Adobe
 * Tags: Array, Two Pointers
 * 
 * Created on 4/3/2016.
 *
 * Given an array of integers.
 * Find elements such that a + b + c = 0
 * Find unique triplets that equals the target sum
 *
 * This problem is for unique numbers.
 *
 * Solution:
 * Sort the numbers so we can compare the size of the running sum
 *
 * We loop through the array and choose the first number.
 * This loop stops at length minus 2.
 *
 * If we are at the first number or the first number is not a duplicate then choose it.
 * The second number is 1 after the first number.
 * The third number is the end of the array.
 *
 * We then calculate a running sum.
 * Loop through the array while the second number is less than the third number.
 *   Compare the running sum by adding the second and third numbers.
 *   If they match our targetsum, then add them into our result list.
 *     increment the second number based on duplicates
 *     decrement the third number based on duplicates
 *   If they do not match, then compare with our target sum
 *     If the running sum is too small, then move the second number to the next.
 *     If the running sum is too large, then move the third number to the previous.
 *
 * Return the result list
 *
 * Runtime: O(N^2)
 *   The first loop is for choose n numbers for the first number.
 *   The second loop is choosing the second and third numbers.
 *
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] numbers, int targetSum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        // sort the input array so all numbers are in order
        Arrays.sort(numbers);

        // choose the first element
        for (int i = 0; i < numbers.length - 2; i++) {
            // index i is the first number
            // or i is greater than zero and is not a duplicate
            if (i == 0 || (i > 0 && numbers[i] != numbers[i - 1])) {
                // the second number is the next index
                int low = i + 1;
                // the third number is from the end of the array
                int high = numbers.length - 1;
                // the new sum is target minus the first number
                int sum = targetSum - numbers[i];

                // loop through the array while the second number
                // is less than the third number
                while (low < high) {
                    if (numbers[low] + numbers[high] == sum) {
                        // we found our numbers
                        result.add(Arrays.asList(numbers[i], numbers[low], numbers[high]));

                        // move past duplicates for the second number
                        while (low < high && numbers[low] == numbers[low + 1]) {
                            low++;
                        }

                        // move past duplicates for the third number
                        while (low < high && numbers[high] == numbers[high - 1]) {
                            high--;
                        }

                        // choose the second and third numbers;
                        low++;
                        high--;
                    } else if (numbers[low] + numbers[high] < sum) {
                        // the current sum is too small so we increment the second number
                        low++;
                    } else {
                        // current sum is too large so we increment the third number
                        high--;
                    }
                }
            }  // end if statement
        }  // end for

        return result;
    }
}
