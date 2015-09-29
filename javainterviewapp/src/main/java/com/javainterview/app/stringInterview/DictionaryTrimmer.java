package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created on 9/28/2015.
 *
 * Given a string s and a dictionary of words dict.
 * Determine if s can be segmented into a space-separated sequence of one or more
 * dictionary words.
 *
 * s = "leetcode";
 * dict = ["leet", "code"]
 * True because "leetcode" becomes "leet code"
 */
public class DictionaryTrimmer {

    /**
     * My idea will be to use 2 indexes.
     * The left index will be the beginning of a word.
     * The second index will move forward and check if the substring is in the dictionary.
     *
     * If the substring is in the dictionary, then move the left index to second index + 1.
     * Then continue moving the second index.
     *
     * Stop processing once the second index reaches the end of the input.
     * If it is successful, then the first index should be past the end of the input string.
     *
     * Otherwise, segmentation failed.
     *
     * @param s    string to segment
     * @param dict dictionary of words
     * @return true if possible
     */
    public boolean segment(String s, Set<String> dict, List<String> segments) {

        int left = 0;
        for (int right = 0; right <= s.length(); right++) {
            // substring is exclusive
            String word = s.substring(left, right);
            if (dict.contains(word)) {
                // move the left pointer to next word
                left = right;
                segments.add(word);
            }
        }

        // the left pointer is at the end because we successfully segmented all words
        if (left >= s.length()) {
            return true;
        }

        // left pointer is not at the end and segmentation failed
        segments.clear();
        return false;
    }
}
