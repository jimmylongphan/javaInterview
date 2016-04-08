package com.javainterview.app.ListInterview;


/**
 * Company: 
 * LinkedIn
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
 * 
 */
public class DepthSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    protected int helper(List<NestedInteger> list, int depth) {
        int result = 0;
        for (NextedInteger e: list) {
            if (e.isInteger()) {
                result += e.getInteger() * depth;
            } else {
                result += e.getInteger() * helper(e.getList(), depth + 1);   
            }
        }
        
        return result;
    }
}