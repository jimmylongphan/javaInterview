package com.javainterview.app.DynamicInterview;

/**
 * LeetCode 53
 *
 * Company: LinkedIn, Bloomberg, Microsoft
 * Tags: Array, Dynamic Programming, Divide and Conquer
 *
 * Created on 10/1/2016.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4]
 * The contiguous subarray [4,-1,2,1] has the largest sum = 6
 *
 */
public class MaximumSubArray {

    /**
     * Linear method to find the max sub array
     * @param nums input of numbers
     * @return the value of the max sub array
     */
    public int maxSubArrayLinear(int[] nums) {

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        // loop through all elements in the array
        for (int i=1; i < nums.length; i++) {
            // add the current number to our previous value

            // using the example, 4 is greater than [-2,1,-3] = -4
            // so we keep the value at index 3 which is value 4
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);

            // only keep the maximum value compared with previous max and the max at this index
            // this is the return value
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // return the highest sub array we have calculated
        return maxSoFar;
    }

    /**
     * Dynamic programming method to find the max sub array
     * @param nums input of numbers
     * @return the value of the max sub array
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // maximum sub array at each index
        int[] dp = new int[n];

        // initialize the sub array
        dp[0] = nums[0];
        int max = dp[0];

        for (int i=1; i < n; i++) {
            // if dp[i-1] is greater than zero, then we have a max solution at i - 1
            // if dp[i-1] is 0, then we do not have a current max
            // take the value and add it to our current num
            // set the max sub array at dp[i] equal to the current num plus the previous max
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);

            // keep a running max
            max = Math.max(max, dp[i]);
        }

        return max;
    }


}
