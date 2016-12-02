package com.javainterview.app.ArrayInterview;

/**
 * Created on 10/8/2016.
 * LeetCode 190 Reverse Bits
 *
 * Company: Apple, Airbnb
 *
 * Tags: Bit Manipulation
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596
 * (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * 0 = 0000
 * 1 = 0001
 * 2 = 0010
 */
public class ReverseBits {
    /**
     * you need treat n as an unsigned val
     * @param n the number to reverse the bits
     * @return the final int val
     */
    public int reverseBits(int n) {
        int result = 0;

        // go through all digits except for last digit
        for (int i = 0; i < 31; ++i) {
            // use bitwise AND to get the leftmost digit
            // add it to our result
            result += n & 1;

            // unsigned shift to the right
            n = n >>> 1;

            // shift result to the left
            result = result << 1;
        }

        // handle last digit
        result += n & 1;

        return result;
    }


}
