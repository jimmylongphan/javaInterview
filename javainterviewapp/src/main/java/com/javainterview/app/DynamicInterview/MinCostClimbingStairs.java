package com.javainterview.app.DynamicInterview;

import java.util.Arrays;

/**
 * Created on 11/16/2019.
 */

/**
 * 746. Min Cost Climbing Stairs
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 *
 * current_cost = cost(n) + Min( cost(n-1), cost(n-2) )
 *
 * cost(3) = 0 + min ( cost(2), cost(1) ) => 30 || 15 => 15
 * cost(2) = 20 + min ( cost(1), cost(0) ) => 20 + 10 => 30
 * cost(1) = 15 + min ( cost(0), 0 )  => 15
 * cost(0) = 10 => 10
 */
public class MinCostClimbingStairs {
    public static int[] costMemoization;

    public int minCostClimbingStairs(int[] cost_array) {
        costMemoization = new int[cost_array.length];
        Arrays.fill(costMemoization, -1);
        return cost(cost_array, cost_array.length);
    }

    public static int cost(int[] cost_array, int index) {
        if (index == 0) {
            return cost_array[0];
        }

        if (index == 1) {
            return cost_array[1];
        }

        if (index == cost_array.length) {
            return Math.min(cost(cost_array, index - 1), cost(cost_array, index - 2));
        }

        if (MinCostClimbingStairs.costMemoization[index] == -1) {
            MinCostClimbingStairs.costMemoization[index] = cost_array[index] + Math.min(cost(cost_array, index - 1), cost(cost_array, index - 2));
        }

        return MinCostClimbingStairs.costMemoization[index];
    }
}