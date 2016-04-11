package com.javainterview.app.stringInterview;


import java.util.LinkedList;
import java.util.List;

/**
 * Company Facebook
 * Problem:
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 *
 * A mapping of digit to letters is given
 *
 * Input:
 * "23"
 *
 * Output:
 * ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * Solution:
 * First create a mapping of the phone digits to the characters.
 *
 * Then we loop through all the digits in the input.
 * Build the combinations starting from length 0.
 * For the first character, we add all digits in the mappings and put the back
 * into the queue.
 * Now the queue has values of length 1
 *
 * Then for the second character, we add all digits in the mappings to the
 * existing values in the queue.
 * Now the queue has values of length 2
 *
 * Continue until we used all characters in the input.
 */
public class LetterCombinationsPhone {

    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        // input check
        if (digits.length() == 0) {
            return result;
        }

        result.add("");

        // loop through all digits in input
        for (int i = 0; i < digits.length(); i++) {
            // convert the digit into a number
            char charDigit = digits.charAt(i);
            int num = Integer.parseInt(Character.toString(charDigit));

            // For every string in the queue that is of length i
            // We know we can add to this string
            // Example:
            // If the original input is of length 2
            // Loop begins with i = 0
            // Start with empty string.
            //   Add all possible values of 1st character and place into queue
            //   Values taken from mapping of the digit
            // Now the queue is full of strings of length 1
            // Loop with i = 1
            //   Take all values with length 1
            //   Add all the values for mappings of 2nd character
            // Now the queue is full of strings of length 2
            while (result.peek().length() == i) {
                // retrieve tempString from queue of current length
                // this length is less than the original input
                String tempString = result.remove();

                // loop through all characters in the mapping
                for (char c : mapping[num].toCharArray()) {
                    // add the character to the tempString
                    // put tempString back into the queue
                    result.add(tempString + c);
                }
            }
        }

        return result;
    }
}