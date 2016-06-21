package com.javainterview.app.ArrayInterview;


/**
 * LeetCode: 283
 * Tags: Array, Two Pointers
 * Company: Facebook, Bloomberg
 * 
 * 
 * 
 * Given an array of integers.
 * Move all non-zeroes to the front of the array.
 *
 * Solution:
 * We will keep an index of where to insert non-zeroes.
 *
 * 2 4 0 5 7
 *
 * 2 -> index 0
 * 4 -> 1
 * 0 -> nothing
 * 5 -> 2
 * 7 -> 3  -> This overwrites the original 5, but 5 has already been moved.
 *
 * Then for all remaining indices. Put a zero.
 * 0 will be put at index 4
 */
public class MoveZeroes {

    public void moveZeroes(int[] numbers) {
        // boundary checks
        if (numbers == null || numbers.length == 0) {
            return;
        }

        // keep track where we can insert
        int insertPos = 0;
        
        // move all numbers up in the array
        for (int num : numbers) {
            // nonzero numbers are where we can insert
            if (num != 0) {
                numbers[insertPos++] = num;
            }
            // if the number is a zero, we go to next number
            // but do not increment insertPos
        }

        // after the loop, we have moved all numbers to front
        // fill all leftover spaces with zeroes
        while (insertPos < numbers.length) {
            numbers[insertPos++] = 0;
        }
    }
}

