package com.javainterview.app.ArrayInterview;

/**
 * LeetCode: 33
 * Company: LinkedIn, Bloomberg, Uber, Facebook, Microsoft
 * Tags: Binary Search, Array
 * 
 * Created on 9/28/2015.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target val to search. If found in the array return its index,
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


    /**
     * This method searches for the position to insert in a rotated array
     * If the array is not rotated, then search within the proper range.
     *
     * If it is rotated, then perform binary search on the array
     * If the middle val is less than its neighbors, then start in the middle.
     * If the middle is greater than both ends, then start after middle
     * If the middle is less than both ends, then start before middle
     * If start is less tha end, then use the current range.
     * Loop until the starting position is greater than end -1.
     * Using end-1 because we will need to use array.length-1 for later.
     *
     * If target is between start and previous, then insert at start.
     * If target is less than the rightmost digit, then find pos aat end.
     * Else Try to find target between 0 and start.
     *
     * @param array  array that is rotated
     * @param target val to insert
     * @return position to insert
     */
    public int findPositionToInsert(int[] array, int target) {
        // the array is not rotated
        if (array[0] < array[array.length - 1]) {
            int position = getPositionWithinRange(array, 0, array.length - 1, target);
            return position;
        }

        int start = 0;
        int end = array.length - 1;

        // loop through array
        // end - 1 because we may insert at end if it is not found
        while (start < end - 1) {
            // calculate the middle val
            int mid = start + (end - start) / 2;
            int midVal = array[mid];

            // check if the middle val is less than both sides
            if (midVal < array[mid + 1] &&
                    midVal < array[mid - 1]) {
                // then the start is the middle
                start = mid;
                break;
            } else if (midVal > array[start] &&
                    midVal > array[end]) {
                // middle is greater than the ends
                // start from the index after middle
                start = mid + 1;
            } else if (midVal < array[start] &&
                    midVal < array[end]) {
                // middle is less than the ends
                // start from the middle minus 1
                end = mid - 1;
            } else if (array[start] < array[end]) {
                // start is less than end, so we can use this range
                break;
            }
        }

        // start is greater than end so we begin at the end
        if (array[start] > array[end]) {
            start = end;
        }

        if (target < array[start] || target > array[start - 1]) {
            // target is between start and the val before start
            // so we insert at start
            return start;
        } else if (target <= array[array.length - 1]) {
            // target is less than the very end
            // so get position from start to end
            return getPositionWithinRange(array, start, array.length - 1, target);
        } else {
            // target is greater than the end
            // so search from left to start
            return getPositionWithinRange(array, 0, start - 1, target);
        }
    }


    /**
     * Find the position to insert the new val given the array and positions
     *
     * @param array  array
     * @param start  beginning to search
     * @param end    end to search
     * @param target val to find
     * @return position where we can insert the val
     */
    private int getPositionWithinRange(int[] array, int start, int end, int target) {

        // loop through the subarray
        while (start < end) {
            // get the middle position
            int mid = start + (end - start) / 2;
            // if we find the target already exists, we are done
            if (target == array[mid]) {
                return mid;
            } else if (target > array[mid]) {
                // the target is larger than the middle
                // search in the right half
                start = mid + 1;
            } else {
                // target is less than the middle
                // search in the left half
                end = mid - 1;
            }
        }

        // finished looping and did not find the target
        // we know the target is greater than the start
        // so return the position after start
        if (target >= array[start]) {
            return start + 1;
        }

        // target is less than start
        // so return start
        return start;
    }
}
