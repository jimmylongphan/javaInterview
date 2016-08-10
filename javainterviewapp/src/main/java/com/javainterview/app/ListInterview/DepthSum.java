package com.javainterview.app.ListInterview;


import java.util.List;

/**
 * LeetCode 339
 * 
 * Company:
 * LinkedIn
 *
 * Tags: Depth-first Search
 * 
 * Problem
 * Given a nested list of integers, return the sum of all integers in the list
 * weighted by their depth.
 * Each element is either an integer or a list - whose elements may also be
 * integers or other lists
 *
 * Example 1:
 * [[1,1],2,[1,1]] return 10
 *
 * Example 2:
 * [1,[4,[6]]]
 * 
 * Runtime:
 * O(n)
 * Depth first search
 * We go through all elements in the data structure.
 */
public class DepthSum {
    public int depthSum(List<NestedInteger> nestedList) {
        // call the helper method with a weight of 1
        return helper(nestedList, 1);
    }

    protected int helper(List<NestedInteger> list, int depth) {
        int result = 0;
        // loop through the nested integer
        for (NestedInteger e : list) {
            // if the item is an integer
            // add it to the sum by multiplying it with the depth weight
            if (e.isInteger()) {
                result += e.getInteger() * depth;
            } else {
                // recursively call the helper method to get the weighted sum of this sublist
                // since we are going down one level, increase the depth
                result += helper(e.getList(), depth + 1);
            }
        }

        return result;
    }
}