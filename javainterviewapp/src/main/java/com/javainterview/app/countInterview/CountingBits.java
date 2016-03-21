package com.javainterview.app.countInterview;

/**
 * Created on 3/20/2016.
 *
 * Problem:
 * Given a non negative integer.
 * For every integer from 0 to num.
 * Find the numbers of 1s and return them in an array.
 *
 * Solution:
 * Take the current rightmost digit for the bits.
 * Then we just need to add the count for the digits to the left.
 * To get all the digits to the left, we shift to the right.
 *
 * Example:
 * 0 -> 0
 * 01 -> Take 1, and then shift to get 0, and count[0] = 0
 * We add 1 with 0.
 * 10 -> Take 0, and then shift to get 1, and we already have count[1]
 * 11 -> Take 1, and shift to get 1, and we already have count for 1
 * 101 -> Take 1, and shift to get 10, and we already have count[10]
 */
public class CountingBits {

    public int[] countBits(int num) {
        // memory to store the count from 0 to num
        // will be 1 index
        int[] counts = new int[num + 1];

        // loop through numbers from 1 to num
        for (int i = 1; i <= num; i++) {
            // take the rightmost digit and add
            // we shift the bits to the right and we should
            // already have the counts for the number shifted
            int previousCount = i >> 1;
            counts[i] = (i & 1) + counts[previousCount];
        }

        return counts;
    }

}
