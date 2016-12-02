package com.javainterview.app.stringInterview;

import java.util.Stack;

/**
 * Created on 10/8/2016.
 *
 * =============================================================================
 * LeetCode 227 Basic Calculator 2
 *
 * Company: Airbnb
 *
 * Tags: String
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers,
 * +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid.
 *
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 *
 *
 */
public class BasicCalculator {
    public int calculate(String s) {
        int len = s.length();

        if (s == null || (len == 0)) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        // default operation is addition
        char operation = '+';

        // loop through all characters in the input string
        for (int i=0; i < len; i++) {
            Character c = s.charAt(i);
            // handles default operation of addition
            if (Character.isDigit(c)) {
                // shift the current number left
                // add the current character converted to actual val
                // ASCII of 0 is 48
                num = num * 10 + c - '0';
            }

            // if the current character is not a digit
            // if it is not a blank
            // or we have reached the end
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                // if the operation is a negative
                if (operation == '-') {
                    // convert the number to a negative
                    stack.push(-num);
                }

                // if the operation is addition
                if (operation == '+') {
                    stack.push(num);
                }

                // if the operation is multiply
                if (operation == '*') {
                    // multiply the current val to num and put back on stack
                    stack.push(stack.pop() * num);
                }

                // if the operation is division
                if (operation == '/') {
                    stack.push(stack.pop() / num);
                }

                // update the current operation
                operation = c;
                // reset the number whenever we encounter an operation
                num = 0;
            }
        }

        // we have finished multiply and divide
        // all subtractions converted the signs
        // just add all values in the stack now
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return  result;
    }

}
