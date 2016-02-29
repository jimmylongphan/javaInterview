package com.javainterview.app.stringInterview;

/**
 * Created on 2/28/2016.
 *
 * Check if string a is a substring of b
 */
public class SubString {

    /**
     * Loop through string b from start to the end minus length of a.
     * For every index from b, compare all characters for a.
     * If all characters match, then return true.
     *
     * If we reached the end without match, then return false.
     *
     * @param sub
     * @param source
     * @return
     */
    public boolean isSubString(String sub, String source) {
        // loop from 0 to end minus sub length
        // If length is 10[0-9], and sub is 5, then last starting index 10-5 = 5.
        for (int startIndex=0; startIndex <= source.length() - sub.length(); startIndex++) {
            // subIndex is from 0 to length-1
            int subIndex;
            for (subIndex=0; subIndex < sub.length(); subIndex++) {
                if (sub.charAt(subIndex) != source.charAt(startIndex+subIndex)) {
                    break;
                }
            }

            // if subIndex reached the end, then all chars matched
            if (subIndex == sub.length()) {
                return true;
            }
        }

        // no match found
        return false;
    }
}
