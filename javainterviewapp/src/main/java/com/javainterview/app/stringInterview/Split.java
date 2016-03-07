package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/6/2016.
 * Twitch
 *
 * Implement the split method.
 * Input is the string and a list of delimiters.
 *
 * Example:  abcdef
 * delimiters:  bc, e
 *
 * result:  a, d, f
 *
 * Runtime: O(n^3)
 *
 * Approach:
 * We will keep 3 indexes.
 *  - start of the result
 *  - start of the delimiter
 *  - end of the delimiter
 *
 * Keep the startIndex of the result at beginning. We only move it after we
 * find a delimiter. Then after splitting the string, we move it to one position after
 * the delimiter.
 *
 * The start of the delimiter will be incrementing through the string.
 * Every time we increment, we will go through all the delimiter.
 * For each delimiter, we will compare all characters in the delimiter with the string.
 * The end index will be incrementing from the startDelim position.
 *
 * If all the characters in the delimiter match, then we have found our delimiter.
 * The result will be from the startIndex to the start of the delimiter.
 * The startIndex will move to 1 after endDelim.
 * The startDelim will be at the new startIndex.
 * The endIndex will be at startIndex.
 */
public class Split {

    public List<String> split(String str, List<String> delimiters) {
        List<String> result = new ArrayList<String>();

        int startIndex = 0;
        int startDelim = startIndex;
        int endDelim = startDelim;

        // loop through string character by character
        while(startDelim < str.length()) {
            // loop through all delimiters
            for (String delim : delimiters) {
                // loop through all characters in delimiters
                boolean foundDelim = true;
                endDelim = startDelim;
                for (int delimIndex = 0; delimIndex < delim.length(); delimIndex++) {
                    if (delim.charAt(delimIndex) != str.charAt(endDelim)) {
                        foundDelim = false;
                        break;
                    } else {
                        endDelim++;
                    }
                }

                // check if
                if (foundDelim) {
                    // substring is exclusive so it is okay
                    result.add(str.substring(startIndex, startDelim));
                    // start index is after the end of the delimiter
                    startIndex = endDelim;
                    // start delimiter is at end, but we will subtract one because startDelim is incrementing
                    startDelim = endDelim-1;
                }
            }

            // move the start delimiter to the next character
            startDelim++;
        }

        // edge case if there are not delimiters at the end
        if (startIndex < str.length()) {
            result.add(str.substring(startIndex, str.length()));
        }

        return result;
    }

}
