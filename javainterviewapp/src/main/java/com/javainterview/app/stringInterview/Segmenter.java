package com.javainterview.app.stringInterview;

import java.util.*;

/**
 * Segment a string such that it can be divided into twitter messages
 * Each message is at most 140 characters
 * Can only segment at a whitespace.
 * Words themselves are not longer than 140 characters.
 *
 * Return a list of string
 */
public class Segmenter {

    /**
     * Using two indexes, the first index is the start of the segment and the second index
     * is the end of the segment.
     *
     * First we try to put the second index at the messageLength.
     * If it is a a valid separator, then we segment the string and move the
     * first index to after the second index.
     *
     * If it is not a valid separator at the second index, then we move backwards until we hit
     * one or if we can no longer move backwards.
     *
     * Edge case is when the second index is passed the end, then we just take the remaining
     * characters.
     *
     * @param s string to segment
     * @param messageLength
     * @return list of segments
     */
    public List<String> segment(String s, int messageLength) {
        List<String> result = new ArrayList<String>();

        // error checking
        if (s == null || s.isEmpty()) {
            return result;
        }

        // keep track of the start index
        int start = 0;

        // keep track of the end
        int end = s.length() - 1;

        // loop through the string
        while (start < end) {
            // create message from index
            int index = start + messageLength;

            // check if we are at the end of the input
            // if so, then add the remaining substring and break
            if (index > end) {
                result.add(s.substring(start, s.length()));
                break;
            }

            // if the break is not a whitespace
            // move the end back until we see whitespace
            while (s.charAt(index) != ' ') {
                --index;
                if (index == start) {
                    break;
                }
            }

            // error check if there are no available spaces
            if (index == start) {
                break;
            }

            // at this point we should have an index at a whitespace
            // the end index is exclusive so we add 1
            result.add(s.substring(start, index+1));

            // move the start to the next character and it is exclusive so we add one.
            start = index+1;
        }  // end while

        return result;
    }
}