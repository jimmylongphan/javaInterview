package com.javainterview.app.DynamicInterview;

/**
 * LeetCode 322
 *
 * Tags: Dynamic Programming
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *  coins = [1, 2, 5], amount = 11
 *  return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 *  coins = [2], amount = 3
 *  return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Created on 9/30/2016.
 */
public class CoinChange {

    /**
     * Call method to return number of coins
     *
     * @param coins array of denominations
     * @param amount value we want to sum
     * @return the number of coins
     */
    public int coinChange(int[] coins, int amount) {
        // cannot get change
        if (amount < 1) {
            return 0;
        }

        // invoke helper method to get change
        return helper(coins, amount, new int[amount]);
    }

    /**
     *
     * @param coins array of denominations
     * @param rem remaining value from previous step
     * @param count count[rem] = number of coins used to sum to rem
     * @return number of coins
     */
    private int helper(int[] coins, int rem, int[] count) {
        // cannot use this coin
        if (rem < 0) {
            return -1;
        }

        // matched exact coins
        if (rem==0) {
            return 0;
        }

        // count[rem] refers to using the current coin
        // count[rem-1] refers to using coins in the previous step
        // if count[rem-1] is nonzero, then we have already calculated the coins used
        if (count[rem-1] != 0) {
            // return the value of coins used
            return count[rem-1];
        }

        // initialize minimum to max
        int min = Integer.MAX_VALUE;

        // looping through all denominations
        for(int coin : coins) {
            // recursively call helper after subtracting a coin of the current denomination
            int result = helper(coins, rem-coin, count);

            // result >= 0 means using this coin can be valid
            // result < min means we have set a coin value, initially it is max
            if (result >=0 && result < min) {
                // since we can use this coin
                // add one coin to our result and store it in min
                min = 1 + result;
            }
        }

        // store the result into count[rem-1]
        // -1 if we cannot use
        // min if we can use this coin
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;

        // return the count of coins in [rem-1]
        return count[rem-1];
    }

}
