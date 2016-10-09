package com.javainterview.app.ListInterview;

import java.util.Stack;

/**
 * Created on 10/8/2016.
 * LeetCode 385
 *
 * Company: Airbnb
 *
 * Tags: Stack, String
 *
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty
 * String does not contain white spaces
 * String contains only digits 0-9, [, - ,, ].
 *
 * Example 1:
 *  Given s = "324",
 *  You should return a NestedInteger object which contains a single integer 324.
 *
 * Example 2:
 *      Given s = "[123,[456,[789]]]",
 *      Return a NestedInteger object containing a nested list with 2 elements:
 *      1. An integer containing value 123.
 *      2. A nested list containing two elements:
 *          i.  An integer containing value 456.
 *          ii. A nested list with one element:
 *              a. An integer containing value 789.
 *
 */
public class MiniParser {

    /**
     * Iterate through the string and add nested integers
     *
     * @param s input string
     * @return a nested integer
     */
    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) {
            return null;
        }

        // special case error where it is not well formed
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            // beginning of a nested list
            if (c == '[') {
                if (current != null) {
                    stack.push(current);
                }
                // create new current for future processing
                current = new NestedInteger();
                // update the new start
                start = end + 1;
            } else if (c == ']') {
                // end of the nested list
                // retrieve the number from the string
                String num = s.substring(start, end); // exclusive
                if (!num.isEmpty()) {
                    // add the integer to the current nested integer
                    current.add(new NestedInteger(Integer.valueOf(num)));
                }

                // if our stack is not empty
                if (!stack.isEmpty()) {
                    // take the top value and add current to it
                    NestedInteger pop = stack.pop();
                    pop.add(current);

                    // current is the popped nested integer
                    current = pop;
                }
                // update the new start
                start = end + 1;
            } else if (c == ',') {
                // more lists to process
                // cannot have a close bracket after a comma
                if (s.charAt(end - 1) != ']') {
                    String num = s.substring(start, end);
                    current.add(new NestedInteger(Integer.valueOf(num)));
                }
                start = end + 1;
            }
        }
        return current;
    }
}
