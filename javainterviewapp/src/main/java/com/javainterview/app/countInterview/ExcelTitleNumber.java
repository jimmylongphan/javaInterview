package com.javainterview.app.countInterview;

/**
 * LeetCode: 171
 * Company: Microsoft Uber
 * Tags: Math
 * 
 * Given a Excel title, convert to the column number
 * A -> 1
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * Solution:
 * We treat the numbers on base 26 instead of base 10.
 * Every time we shift left, it is multiplied by 26, not 10.
 * Then we add the current digit based on capital 'A'
 */
public class ExcelTitleNumber {

    public int titleToNumber(String s) {
        int result = 0;

        // loop through all characters
        int charValue;
        for (int i = 0; i < s.length(); i++) {
            // converts the character at this position to a number
            // based on capital A
            charValue = (s.charAt(i) - 'A') + 1;

            // shift the result to the left on base 26
            result *= 26;

            // add the rightmost character
            result += charValue;
        }

        return result;
    }
}