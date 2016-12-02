package com.javainterview.app.stringInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 340
 *
 * Company Google
 * Tags: Hash Table, String
 *
 * Created on 9/26/2015.
 *
 * Given a string, find the longest substring that contains only two unique characters.
 * For example, given  "abcbbbbcccbdddadacb", the longest substring that contains 2
 * unique character is "bcbbbbcccb".
 *
 * Google question
 */
public class LongestSubstring {

    /**
     * Loop through the string using an index and a trailing start cursor.
     * Then we keep a count of the characters in a map.
     *
     * The first cursor goes through the string and as long as we have less than
     * k unique characters, we keep moving.
     *
     * Once we have more unique characters than k,
     * then we check our max length substring.
     *
     * Then we increment the trailing start cursor and decrement our counts.
     * Keep incrementing the start cursor until we no longer have too many unique characters.
     *
     * Once we reach the end, return the maxsubstring.
     *
     * Runtime O(n):  looping through the string
     * Space O(n):  keeping track of counts
     */
    public String maxSubStringKUniqueChars(String s, int k) {
        // keep characters and their count
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int start = 0;
        int maxLen = 0;
        String maxSubstring = null;

        // loop through the incoming string
        for (int i = 0; i < s.length(); i++) {
            // add each char to the counter
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // increment the length
                map.put(c, map.get(c) + 1);
            } else {
                // add new entry with length of 1
                map.put(c, 1);
            }

            // check uniqueness count
            // once we have 1 more than k unique chars, then check the length of our string
            if (map.size() == k + 1) {
                // get maximum
                // the distance between start and i
                int length = i - start;

                // if we find our new longest length string
                // store the length and substring
                if (length > maxLen) {
                    maxLen = length;
                    maxSubstring = s.substring(start, i);
                }

                // move the start cursor toward right
                // so that substring contains only k chars
                // keep moving until we can use new chars
                while (map.size() > k) {
                    char startChar = s.charAt(start);
                    int count = map.get(startChar);

                    // since we will move the start cursor to the right
                    // the count of the characters at the start cursor will decrease
                    if (count > 1) {
                        map.put(startChar, count - 1);
                    } else {
                        // since there was only 1 char at start and we are moving forward
                        // remove this entry
                        map.remove(startChar);
                    }
                    // move the start cursor
                    start++;
                }
            }  // end boundary check
        }  // end for loop


        // default case where the input matches exactly what we want
        if (map.size() == k && maxLen == 0) {
            return s;
        }

        // return the new maxSubstring
        return maxSubstring;
    }


    /**
     * Runtime: O(n * n)
     *
     * Keep an array Count where the index is the ascii code
     * and the val is the count.
     *
     * Move the end position until we reached our max k.
     * Then move the start position forward until we are less than k.
     *
     * After every update, calculate the new max length
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] letterCount = new int[256];
        int currentDistinctCount = 0;
        int startPos = 0;
        int length = 0;

        for (int endPos = 0; endPos < s.length(); endPos++) {
            // see character for first time
            if (letterCount[s.charAt(endPos)]++ == 0) {
                currentDistinctCount++;
            }

            // reached the limit
            if (currentDistinctCount > k) {
                // move the startPos forward and decrement count
                while (--letterCount[s.charAt(startPos++)] > 0) {
                    // do nothing
                }
                currentDistinctCount--;
            }
            // find our max length
            length = Math.max(length, endPos - startPos + 1);
        }

        return length;
    }
}
