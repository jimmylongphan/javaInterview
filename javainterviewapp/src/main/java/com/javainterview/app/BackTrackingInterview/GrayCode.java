package com.javainterview.app.BackTrackingInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 89
 * 
 * Tags: Backtracking
 * Company: Amazon
 * 
 * The gray code is a binary numeral system where two successive 
 * values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence 
 * according to the above definition.
 * 
 * shift the current value to the right.
 * 00 -> 00, ^ = 00
 * 01 -> 00, ^ = 01
 * 10 -> 01, 10 ^ 01 = 11
 * 11 -> 01, ^ = 10
 * 
 * Understanding. Since we only want to differ by 1 bit. 
 * We shift the current value to the right by 1.
 * xor all the values to make a different value by 1 bit.
 */

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();

        // n represents the total bits in the code
        // max value is one shifted n times
        // n = 2
        // 1 << 2:  1 -> 10 -> 100
        // loop all from 00 to 11, less than 100
        int maxValue = 1 << n;

        // loop through all values from 0 to max
        int xorVal;
        for (int i = 0; i < maxValue; i++) {
            // shift the current val to the right
            xorVal = i >> 1;

            // xor the current number with the xorVal
            // add to our result
            result.add(i ^ xorVal);
        }

        return result;
    }
}