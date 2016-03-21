package com.javainterview.app.ArrayInterview;

/**
 * Created on 3/20/2016.
 *
 * Given an array of integers.
 * Return an array where each index is the product of all elements in the array
 * except for the number at that index.
 *
 * [1,2,3,4], return [24,12,8,6]
 *
 * Solution:
 * Calculate the products before the current number.
 * Calculate the products after the current number.
 */
public class ProductArray {

    public int[] productArray(int[] numbers) {
        int length = numbers.length;
        int[] result = new int[length];
        if (numbers == null || length == 0) {
            return result;
        }

        // initialize the running prefix
        int runningPrefix = 1;

        // loop through all numbers left to right
        for (int i = 0; i < length; i++) {
            // update the current number by using previous product
            result[i] = runningPrefix;

            // update the product by multiplying the current number
            runningPrefix = runningPrefix * numbers[i];
        }

        int runningSuffix = 1;
        // loop through all numbers from right to left
        for (int i = length - 1; i >= 0; i--) {
            // update current number by multiplying suffix
            result[i] = result[i] * runningSuffix;

            // when moving left, update suffixx by multiplying the
            // current number
            runningSuffix = runningSuffix * numbers[i];
        }

        return result;
    }
}
