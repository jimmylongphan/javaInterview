package com.javainterview.app.countInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 202
 * Company: Uber, Airbnb, Twitter
 * Tags: Hash, Math
 * 
 * Created on 10/3/2015.
 *
 * Start with any positive integer.
 * Replace the number by the sume of the squares of its digits.
 * Repeat until the final value equals 1.
 * Or loops in a cycle that does not include 1.
 *
 * If it equals 1 then happy.
 * If it does not equal then unhappy.
 */
public class HappyNumbers {


    /**
     * Idea is to loop through all the rightmost digits using modulo 10.
     * Then keep a running sum by squaring that digit.
     *
     * Do this for all the digits in the number.
     * Then repeat for the new sum.
     *
     * If the final sum cycles itself, we stop processing.
     *
     * If the final sum is 1, it is happy.
     *
     * Runtime: O(n^2)
     *
     * @param num to check for happiness
     * @return true if happy
     */
    public boolean isHappy(int num) {
        Set<Integer> values = new HashSet<Integer>();

        // check if we never process this number before
        while (!values.contains(num)) {
            // processing this number
            values.add(num);

            // calculate the sum of squares of digits
            int sum = 0;
            int digit;
            while (num > 0) {
                // get rightmost digit
                digit = num % 10;

                // calculate square and add to sum
                sum += digit * digit;

                // shift digits
                num /= 10;
            }

            // this is the new number to process
            // if it reaches 1, then it will repeat at 1
            num = sum;
        }

        // number repeated at 1
        if (num == 1) {
            return true;
        }

        // number repeated not at 1.
        return false;
    }

}
