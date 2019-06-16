package com.javainterview.app.BackTrackingInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 131
 *
 * Company: Bloomberg
 * Tags: Backtracking
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab"
 * Return
 *
 * [
 * ["aa","b"],
 * ["a","a","b"]]
 *
 *
 * Created on 12/27/2016.
 */
public class PalindromePartitioning {
    /**
     * Public method to check if the indexes in a string are a palindrome
     * If start == end, then is it a 1 char palindrome
     *
     * @param s     original string
     * @param start starting position to check
     * @param end   ending position to check
     * @return true if palindrome
     */
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Starter method for backtracking
     *
     * @param s original string
     * @return list of palindromes
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();

        partitionHelper(s, result, new LinkedList<>(), 0);

        return result;
    }

    /**
     * @param s          original string
     * @param result     the final result of list of lists
     * @param current    the current list of the partitioned string to become a palindrome
     * @param startIndex the current starting index in this recursive loop
     */
    private void partitionHelper(String s, List<List<String>> result, LinkedList<String> current, int startIndex) {
        // base case check if we are done
        if (startIndex == s.length()) {
            // reached the end of the string
            // we are done with this loop
            // make a copy of the current list
            result.add(new LinkedList<>(current));
            return;
        }

        // iterate from current position to the end
        // this creates our sub strings to check for palindromes
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            // check if the current substring can be a palindrome
            if (isPalindrome(s, startIndex, endIndex) == false) {
                continue;
            }

            // this substring is our pick
            // substring is exclusive
            current.add(s.substring(startIndex, endIndex + 1));

            // recursive call with the currentVal and updated params
            // the new startIndex is after the current endIndex
            partitionHelper(s, result, current, endIndex + 1);

            // remove the current pick
            current.remove(current.size() - 1);
        }
    }

}
