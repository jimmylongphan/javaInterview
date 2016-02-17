package com.javainterview.app.ListInterview;

import java.util.*;

/**
 * Created on 10/4/2015.
 */
public class CheckParenthesis {


    public boolean hasValidParenthesis(String s) {
        // stack will keep track of characters First-In-Last-Out
        Stack<Character> stack = new Stack<Character>();

        // keep track of all pairs
        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');
        pairs.put('>', '<');

        // keep track of all opening characters
        Set<Character> openingChars = new HashSet<Character>(pairs.values());

        // loop through the characters in the string
        for (char c : s.toCharArray()) {
            // if value is an opening then add it
            if (openingChars.contains(c)) {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                // the character is a closing char
                if (stack.peek() == pairs.get(c)) {
                    // the top of the stack is an opening char
                    stack.pop();
                } else {
                    // mismatched closing and opening characters
                    return false;
                }
            }
        }

        // if all values popped off successfully then this string is good
        return stack.isEmpty();
    }


    /*
    * input: int n
    * output: valid parenthesis combinations for n
    * example: n = 2
    * ()(),  (())
    * ())( -> this is not a valid one
    *
    * n = 3
    * ((()))
    * (()())
    * (())()
    * ()(())
    * ()()()
    */
    public void generateParenthesis(List<String> result, String s, int openCountRemaining, int closeCountRemaining) {
        if ( openCountRemaining > closeCountRemaining ) {
            return;
        }

        if (openCountRemaining == 0 && closeCountRemaining == 0) {
            result.add(s);
            return;
        }

        if (openCountRemaining > 0) {
            generateParenthesis(result, s + "(", openCountRemaining - 1, closeCountRemaining);
        }

        if (closeCountRemaining > 0) {
            generateParenthesis(result, s + ")", openCountRemaining, closeCountRemaining - 1);
        }
    }


}
