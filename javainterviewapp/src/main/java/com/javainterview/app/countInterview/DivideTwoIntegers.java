package com.javainterview.app.countInterview;


/**
 * LeetCode: 28
 * Tags: Math, Binary Search
 * 
 * 
 * Divide two integers without multiplicaiton, division, and mod
 * If it is overflow, return MAX_INT
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        // check if the val is 0
        if (dividend == 0) {
            return 0;
        }

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // check for opposite signs
        boolean isNegative = false;
        if (dividend < 0 && divisor > 0) {
            isNegative = true;
        } else if (dividend > 0 && divisor < 0) {
            isNegative = true;
        }

        // convert to absolute val long to handle overflow
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long result = 0;

        // second loop 1 > 2, will break
        while (lDividend >= lDivisor) {
            int shift = 0;
            // we shift the divisor to the left
            // this multiplies the divisor by two
            while (lDividend > (lDivisor << shift + 1)) {
                shift++;
            }
            // Example 17/2
            // stop at 4, 8, 16, 32 -> shift = 3

            // the divisor will be off by one, because we will stop
            // when the divisor is greater
            // subtract the shifted 
            lDividend -= (lDivisor << shift);
            // new dividend is 17 - (2 << 3) = 17 - 16 = 1

            // The result is the amount shifted
            // In example 17/2, shift is 3
            // result = 0 + (1 << 3) = 8
            result += (1 << shift);
        }

        // use proper sign        
        if (isNegative) {
            result = -result;
        }

        // handle overflow
        // Restrict boundary to integer
        result = Math.min(Integer.MAX_VALUE, result);

        // Restrict boundary to integer size
        result = Math.max(Integer.MIN_VALUE, result);

        // return integer val
        return (int) result;
    }

}