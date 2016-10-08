package com.javainterview.app.ArrayInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 219
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
 * Created on 10/8/2016.
 */
public class ContainsDuplicate2
{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        // maintain a sliding window
        for (int i=0; i < nums.length; i++) {
            // once i is greater than k,
            // then we will trim the earlier elements
            if (i > k) {
                // we only keep the set size of k
                // remove the numbers earlier in the array
                // example i = 5, k = 4, remove 5-4-1 = index 0
                // remove index 0, keeping indices 1-4
                // did not add nums[5] yet
                set.remove(nums[i-k-1]);
            }

            // duplicate exists if this is false
            // check if our nums[5] is already in our set
            if (!set.add(nums[i]))
            {
                // if it is already in our set, we are done
                return true;
            }
        }

        // no duplicates in our set
        return false;
    }
}
