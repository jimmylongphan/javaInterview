package com.javainterview.app.Design;


/**
 * LeetCode 198
 * 
 * Company: LinkedIn, Airbnb
 * 
 * Tags: Dynamic Programming
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have security 
 * system connected and it will automatically contact the police if two adjacent 
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of 
 * each house, determine the maximum amount of money you can rob tonight 
 * without alerting the police.
 * 
 * Idea: is it somewhat all even or all odd houses are robbed
 */
public class HouseRobber {
    public int rob(int[] nums) {
        // sum if the previous house was not robbed
        int prevNo = 0;
        // sum if the previous houe was robbed
        int prevYes = 0;
        
        // loop through all the houses
        for (int n : nums) {
            // temporarily store if the previous house was not robbed val
            int temp = prevNo;
            
            // we will set the previous not robbed to be the max of either
            // the previous not robbed or the previously robbed house
            prevNo = Math.max(prevNo, prevYes);
            
            // if we rob this current house, then we can only add the
            // old previous not robbed house
            prevYes = n + temp;
        }
        
        // return the final val all choosing which houses to rob or not
        // order does not matter because it is addition
        return Math.max(prevNo, prevYes);
    }
    
}

