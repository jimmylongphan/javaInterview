package com.javainterview.app.ArrayInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 5/8/2016.
 *
 * LeetCode: 325
 * Company: Palantir, Facebook
 * Tags: Hash Table
 * 
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 *
 * Given nums = [1, -1, 5, -2, 3], k = 3
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 * Map:
 *   Key:  sum of all elements before Index
 *   Value:  current Index
 * 
 * Idea:
 *   previousExistingSum + currentSum = targetK
 * 
 *   In the loop, we subtract currentSum - targetK,
 *   this gives us a value that will work if we subtract previousExistingSum from
 *   our currentSum.
 *   We look up this previousExistingSum for its index.
 *   To get our new max length, we subtract current index - previousIndex.
 * 
 *   Check if this new length is greater than our current i.
 * 
 * Solution:
 * Runtime: O(n)
 * 
 */
public class MaxSubArrayLen {
    public int maxSubArrayLen(int[] nums, int k) {

        int sum = 0;
        int maxLength = 0;
        int previousSum = 0;
        // stores <sum, index>
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            // update sum with the current number
            sum = sum + nums[i];
            previousSum = sum - k;

            // found our target, keep the length
            if (sum == k) {
                maxLength = i + 1;
            } else if (map.containsKey(previousSum)) {
                // the map contains (currentSum - target)
                // use the length of the array that contains that (currentSum - target)
                // subtract the current value and the index of that previous sum

                // Solution
                // we check if this current index and sum can work if we subtract a bad sum
                // to get the bad sum, we subtract (sum - k)
                // that value is the one we need to eliminate
                // Get the index of that bad sum value
                // subtract the current index from that bad index
                // see if it is better than our current max length
                maxLength = Math.max(maxLength, i - map.get(previousSum));
            }

            // this value is new, add it into the map
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
