package com.javainterview.app.countInterview;


/**
 * Given non-negative integer. Add all digits until only a single digit remains.
 *
 * 38 => 3 + 8 = 11 -> 1 + 1 -> 2
 *
 * Solution:
 *   Simple brute force using a loop
 *
 *   Or use the digital root idea.
 *   Where we use mod from the base
 *   So base 10 we will mod 9
 *   or mod(b-1)
 */
public class AddDigits {

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        if (num % 9 == 0) {
            return 9;
        }

        return num % 9;
    }

    public int addDigitsLoop(int num) {
        int digit = 0;
        int currentSum = 0;

        while (num >= 10) {
            // get rightmost digit
            digit = num % 10;

            // shift digits right
            num = num / 10;

            // add the sum
            currentSum += digit;

            // check when to use new sum
            if (num < 10) {
                num = currentSum + num;
                // reset currentSum
                currentSum = 0;
            }
        }

        return num;
    }

}