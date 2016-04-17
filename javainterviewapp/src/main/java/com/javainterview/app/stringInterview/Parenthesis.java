package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2/29/2016.
 * Uber
 *
 * Generate all valid parenthesis combinations of a given number.
 * 1 -> ()
 * 2 -> ()(), (())
 *
 * Valid means that a close parenthesis cannot appear before an open parenthesis.
 * Every open parenthesis must have a corresponding close parenthesis.
 */
public class Parenthesis {

    /**
     * Method called to generate given a count
     *
     * @param count number of pairs to produce
     * @return List of the combinations
     */
    public List<String> generateParenthesis(int count) {
        List<String> results = new ArrayList<String>();

        String dummyStr = "";
        recursiveGenerator(results, dummyStr, count, count);

        return results;
    }

    /**
     * Cannot have less closeCountRemaining than openCountRemaining.
     *
     * Using depth first search to generate the strings
     * We only go down the path that has valid input.
     * If we reach a node that does not satisfy the input, then we return.
     *
     * @param results list of all the result combinations
     * @param current The current generating string
     * @param openCountRemaining keep track of how many open parenthesis are left
     * @param closeCountRemaining keep track of how many close parenthesis are left
     */
    protected void recursiveGenerator(List<String> results, String current, int openCountRemaining, int closeCountRemaining) {
        // boundary check
        if (openCountRemaining < 0 || closeCountRemaining < 0) {
            return;
        }

        // cannot have more close parenthesis than open parenthesis in current string
        if (closeCountRemaining < openCountRemaining) {
            return;
        }

        // check if all parenthesis have been consumed
        if (openCountRemaining == 0 && closeCountRemaining == 0) {
            // this is a valid string
            results.add(current);
            return;
        }

        // generate the open parenthesis
        recursiveGenerator(results, current + "(", openCountRemaining-1, closeCountRemaining);

        // generate the close parenthesis
        recursiveGenerator(results, current + ")", openCountRemaining, closeCountRemaining-1);
    }

}
