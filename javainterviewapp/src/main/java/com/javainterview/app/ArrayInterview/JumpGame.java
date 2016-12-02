package com.javainterview.app.ArrayInterview;

/**
 * TODO test
 * LeetCode 55
 *
 * Company: Microsoft
 * Tags: Array, Greedy
 *
 * Created on 9/30/2016.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 */
public class JumpGame {

    /**
     * Check if it is possible to reach the end of the array
     *
     * @param nums incoming array
     * @return true if can be reached
     */
    public boolean canJump(int[] nums) {
        return canJump(nums, nums.length-1);
    }

    /**
     * Helper method to check if we can reach the target index in this array
     *
     * @param nums incoming array
     * @param target desired index to reach
     * @return true if target can be reached
     */
    private boolean canJump(int[] nums, int target) {
        // current max distance we can jump
        int maxDistance = 0;

        // go through all possible distance jumps from 0 to max
        for (int currentDistance = 0; currentDistance <= maxDistance; currentDistance++) {
            // our new max distance is either
            // current max or
            // currentDistance added with the new val at the currentDistance
            maxDistance = Math.max(maxDistance, currentDistance + nums[currentDistance]);

            // if our maximum jump can reach the target
            // we are done
            if (maxDistance >= target) {
                return true;
            }
        }

        // cannot reach the target
        return false;
    }
}
