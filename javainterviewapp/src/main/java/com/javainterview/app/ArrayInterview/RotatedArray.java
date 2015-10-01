package com.javainterview.app.ArrayInterview;

/**
 * Created on 9/28/2015.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1.
 *
 * Assume no duplicates in the array.
 */
public class RotatedArray {

    /**
     * Search in this array for the target
     *
     * @param nums   array of numbers
     * @param target number to find
     * @return index of target
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    /**
     * Perform binary search on rotated array.
     * It is essentially the same as binary search, where we check if the target
     * should be to the left or to the right.
     *
     * However, parts of the array can be rotated, which means the left number is greater
     * than the middle number. Then we just check the other side because we know it's been
     * rotated.
     *
     * Runtime: O(log n)
     *
     * @param nums   array of numbers
     * @param left   leftmost index
     * @param right  rightmost index
     * @param target number to find
     * @return
     */
    private int binarySearch(int[] nums, int left, int right, int target) {
        // exhausted all search
        if (left > right) {
            return -1;
        }

        // get the middle index
        int mid = left + (right - left) / 2;

        // found our number
        if (target == nums[mid]) {
            return mid;
        }

        // left side is within the same segment of the rotation
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                // target should be between left and middle-1 index
                return binarySearch(nums, left, mid - 1, target);
            } else {
                // target should be between middle+1 and right side
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            // right side within same segment of rotation
            // this means right side of array was rotated
            if (nums[mid] < target && target <= nums[right]) {
                // target is between middle+1 and right side
                return binarySearch(nums, mid + 1, right, target);
            } else {
                // target is between left and middle-1
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }

}
