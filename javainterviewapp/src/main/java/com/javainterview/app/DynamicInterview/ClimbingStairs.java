package com.javainterview.app.DynamicInterview;

/**
 * LeetCode: 70
 *
 * Company: Adobe, Apple
 *
 * Tags: Dynamic Programming
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Created on 10/1/2016.
 *
 * Idea:
 * Base cases
 * If 0 steps, then 0 ways
 * If 1 step, then 1 way to climb stair
 * If 2 step, then 2 ways to climb stair
 *
 * Fibonacci sequence
 * For example, to get to step 3
 * 1. 1,1,1
 * 2. 1,2
 * 3. 2,1
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // base case
        if (n <= 0) {
            return 0;
        }
        // 1 step stair
        if (n == 1) {
            return 1;
        }
        // 2 step stair
        if (n == 2) {
            return 2;
        }

        // initialize base cases
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        // loop from 2 until the nth step
        for (int i=2; i<n; i++) {
            // the current way is the sum of the previous two ways
            all_ways = one_step_before + two_steps_before;
            // update the previous 2nd way with the previous 1 way
            two_steps_before = one_step_before;

            // update the previous way with the current way
            one_step_before = all_ways;
        }

        // return all ways
        return all_ways;
    }

}
