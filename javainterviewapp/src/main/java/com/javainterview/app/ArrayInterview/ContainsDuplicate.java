package com.javainterview.app.ArrayInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 217 Contains Duplicate
 *
 * Company: Palantir, Airbnb, Yahoo
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any val appears at least twice in
 * the array, and it should return false if every element is distinct.
 *
 * Tags: Array, Hash Table
 *
 * =============================================================================
 * LeetCode 219 Contains Duplicate 2
 *
 * Company: Palantir, Airbnb
 *
 * Tags: Array, Hash Table
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and the difference between i and j is at most k.
 *
 * NOTE:
 * maintain a sliding window of size k
 * once we are at k, then trim the earlier elements
 * check if our current nums[i] is already in our set
 *
 * ============================================================================
 *
 * LeetCode 220 Contains Duplicate 3
 *
 * Company: Palantir, Airbnb
 *
 * Tags: Binary Search Tree
 *
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the difference between nums[i] and nums[j] is at most t
 * and the difference between i and j is at most k.
 */
public class ContainsDuplicate {
    /**
     * Contains Duplicate 1
     *
     * @param nums original array
     * @return true if duplicate exists
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // loop through array and check if val already exists
        for (int i = 0; i < nums.length; ++i) {
            // val already exists so we cannot add
            if (!set.add(nums[i])) {
                return true;
            }
        }

        // all elements distinct
        return false;
    }


    /**
     * Contains Duplicate 2
     * LeetCode 219
     *
     * @param nums original array
     * @param k    max distance for sliding window
     * @return true if duplicate exists
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        // maintain a sliding window
        for (int i = 0; i < nums.length; i++) {
            // once i is greater than k,
            // then we will trim the earlier elements
            if (i > k) {
                // we only keep the set size of k
                // remove the numbers earlier in the array
                // example i = 5, k = 4, remove 5-4-1 = index 0
                // remove index 0, keeping indices 1-4
                // did not add nums[5] yet
                set.remove(nums[i - k - 1]);
            }

            // duplicate exists if this is false
            // check if our nums[5] is already in our set
            if (!set.add(nums[i])) {
                // if it is already in our set, we are done
                return true;
            }
        }

        // no duplicates in our set
        return false;
    }

    /**
     * LeetCode 220 Contains Duplicate 3
     *
     * @param nums original array
     * @param k    distance between numbers
     * @param t    max val between numbers, bucket size will be t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // error cases
        // numbers have to be distinct and t is absolute val
        if (k < 1 || t < 0) {
            return false;
        }

        // Key bucket slot
        Map<Long, Long> map = new HashMap<>();

        // if t = 3, then values 0,1,2,3 are duplicates
        // using t + 1 because it is <=
        long bucketSize = (long) t + 1;

        for (int i = 0; i < nums.length; i++) {
            // force all numbers to be positive
            // this is why we are using long instead of int
            long positiveNum = (long) nums[i] - Integer.MIN_VALUE;

            // divide the positive number by the bucket size
            // to determine which bucket to insert
            long bucket = positiveNum / bucketSize;

            // check if current bucket exists
            if (map.containsKey(bucket)) {
                return true;
            }
            // check if previous bucket exists and positive num is less than the
            // numbers in the previous bucket
            if (map.containsKey(bucket - 1) && positiveNum - map.get(bucket - 1) <= t) {
                return true;
            }
            // check if the next bucket exists and the positive num in that
            // bucket is within the bucket size
            if (map.containsKey(bucket + 1) && map.get(bucket + 1) - positiveNum <= t) {
                return true;
            }

            // maintain our window size of k
            if (map.entrySet().size() >= k) {
                // get the number at the earliest slot and get its positive val
                long earliestVal = (long) nums[i - k] - Integer.MIN_VALUE;
                // find the bucket that belongs to the earliest val
                long lastBucket = earliestVal / bucketSize;
                // remove that bucket
                map.remove(lastBucket);
            }

            // insert our new bucket
            map.put(bucket, positiveNum);
        }

        return false;
    }
}
