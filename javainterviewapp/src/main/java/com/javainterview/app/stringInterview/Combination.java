package com.javainterview.app.stringInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * LeetCode: None, Similar to 22
 * Company: FitBit
 * Tags: Backtracking, String,
 *
 * Asked on 8/19/2016
 *
 * Given an input string with curly brace brackets.
 * Output all combinations using the words inside the brackets
 *
 * {Bob,Jen} went to the {park,beach} yesterday
 * Generates 4 strings
 */
public class Combination {

    public List<String> printCombinations(String input) {
        List<String> result = new ArrayList<>();

        int firstCurly = input.indexOf('{');
        if (firstCurly != -1) {
            // get the second curly
            int secondCurly = input.indexOf('}');

            // get the entire replacement strings
            String comboWords = input.substring(firstCurly, secondCurly+1);

            // replace the curly braces
            String templateString = input.replace(comboWords, "%s");

            // remove the curly braces
            comboWords = comboWords.substring(1, comboWords.length()-1);

            // tokenize the words
            StringTokenizer st = new StringTokenizer(comboWords, ",");
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                // fill in template and recursively call method
                String input2 = String.format(templateString, word);

                // recursively call the method with the filled in template
                result.addAll(printCombinations(input2));
            }
        } else {
            // the input no longer has curly braces
            // add it to result
            result.add(input);
        }

        return result;
    }

}
