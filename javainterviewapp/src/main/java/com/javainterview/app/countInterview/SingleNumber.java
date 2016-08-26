package com.javainterview.app.countInterview;


/**
 * Leetcode: 136
 * Company: Palantir, Airbnb
 * Tags: Hash Table, Bit Manipulation
 * 
 * Given an array of integers, every element appears twice except one.
 * Find the integer.
 *
 * Solution: O(n)
 *
 * XOR is commutative, so changing the order does not have an effect.
 *
 * N XOR N = 0
 * A XOR 0 = A
 *
 * If we XOR all the numbers together, eventually we will be left with the
 * excluded number.
 */

public class SingleNumber {

    /**
     * This solution is to find a single number.
     *
     * @param numbers
     * @return
     */
    int singleNumber(int numbers[]) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result ^= numbers[i];
        }
        return result;
    }

    /**
     * Modification of single bit.
     * Used to find two numbers that are different in the array.
     *
     * Solution:
     * We will use the same XOR value from before.
     * This gets us the XOR of both numbers.
     * Since we know that having a 1 is where the two numbers diff.
     *
     * Then we loop through the numbers again
     * We compare the bit with the numbers.
     * We treat the numbers into 2 groups.
     * 1st group has bits that match the 1st number.
     * 2nd group has bits that match the 2nd number.
     * We can find this by using a 1 bit in the first diff.
     */
    int[] doubleNumber(int numbers[]) {
        int combinedDiff = 0;
        for (int num : numbers) {
            combinedDiff ^= num;
        }
        // This gets the combined XOR digits for both numbers
        // get the highest one bit of the combined number
        int diffBit = Integer.highestOneBit(combinedDiff);
        int[] result = new int[2];

        for (int num : numbers) {
            if ((diffBit & num) == 0) {
                // one group of numbers will not match diff bit
                // xor them into first group
                result[0] ^= num;
            } else {
                // second group of numbers will match diff bit
                // xor them into second group
                result[1] ^= num;
            }
        }

        // the result should now have the two correct numbers
        // because we xor all of the numbers with the diff bit
        return result;
    }

}



