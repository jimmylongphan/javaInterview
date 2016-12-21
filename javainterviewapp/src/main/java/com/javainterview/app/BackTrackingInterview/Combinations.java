package com.javainterview.app.BackTrackingInterview;


/**
 * LeetCode 77
 * 
 * Tags: Backtracking
 * Company:
 * 
 * Given two integers n and k, 
 * return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example.
 * If n = 4 and k = 2, a solution is:
 * 
 * [  [2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 * 
 * O(N!) factorial, for every choice, the is a (current-1) recursion
 * 
 */
 
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        
        List<Integer> current = new LinkedList<>();
        combineHelper(result, current, 1, n, k);
        
        return result;
    }
    
    public void combineHelper(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // k is current size
        // no more to process, add the current temp result
        if (k == 0) {
            // make a copy of the result
            result.add(new LinkedList<Integer>(current));
        }
        
        // iterate through all values
        for (int i=start; i<=n; i++) {
            // choose our current value
            current.add(i);
            
            // recursively call with this new value
            // update the starting value, and decrease the k size
            combineHelper(result, current, i+1, n, k-1);
            
            // remove our latest choice
            current.remove(current.size() - 1);
        }
    }
}