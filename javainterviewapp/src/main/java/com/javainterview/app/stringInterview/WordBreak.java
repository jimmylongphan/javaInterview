package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created on 3/20/2016.
 *
 * Given a string s and dictionary of words.
 * Determine if s can be segmented into a space
 * separated sequence of one or more dictionary words.
 */
public class WordBreak {

    public List<String> wordBreak(String s, Set<String> dictionary) {
        List<String> result = new ArrayList<String>();

        // keep track of whether all positions can be broken
        // add an extra 1 because the substring method is exclusive
        boolean[] breakable = new boolean[s.length() + 1];

        // starting position is breakable
        breakable[0] = true;

        // loop through all indices starting from index 1
        // substring is exclusive
        for (int endIndex = 1; endIndex < s.length() + 1; endIndex++) {
            // start at index 0 and end at at the end index
            for (int beginIndex = 0; beginIndex < endIndex; beginIndex++) {
                String sub = s.substring(beginIndex, endIndex);
                if (breakable[beginIndex] && dictionary.contains(sub)) {
                    breakable[endIndex] = true;
                    result.add(sub);
                    break;
                }
            }
        }

        // this shows all characters are breakable
        // off by 1 - accessing the very last index
        if (breakable[s.length()]) {
            return result;
        }

        return null;
    }

}
