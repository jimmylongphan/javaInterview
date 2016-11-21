package com.javainterview.app.ArrayInterview;

/**
 * Created on 11/20/2016.
 *
 * LeetCode 189 Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
 *
 * Visualization
 * When k is positive, the 0 to k-1 is reverse of the original reversed array, then k to n-1
 * [7, 6, 5, 4, 3, 2, 1]
 * [5, 6, 7, 1, 2, 3, 4]
 *
 * When k is negative, the 0 to k is reverse of the original reversed array, then k+1 to n - 1
 * [7, 6, 5, 4, 3, 2, 1]
 * [4, 5, 6, 7, 1, 2, 3]
 *
 * Company: Microsoft, Bloomberg, Paypal
 * Tags: Arrays
 *
 * Runtime: O(n) + O(n)
 *
 * Also handle if k is negative
 */
public class RotateArray {
    /**
     * Method to rotate an array
     *
     * @param nums the original array
     * @param k    the amount to shift
     */
    public void rotate(int[] nums, int k) {
        // first we make sure k fits into the length of the array
        k %= nums.length;
        if (k == 0) {
            // no work needed
            return;
        }

        // reverse the entire array
        reverse(nums, 0, nums.length - 1);
        // there is a pattern to the rotation
        if (k >= 0) {
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        } else {
            reverse(nums, k + 1, nums.length - 1);
            reverse(nums, 0, k);
        }

    }

    /**
     * Helper method to reverse an array between start and end index
     *
     * @param nums  array to reverse
     * @param start the first position to reverse
     * @param end   the last position to reverse
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
