package com.javainterview.app.ListInterview;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Company:
 * Google
 *
 * Problem:
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may
 * also be integers or other lists.
 *
 * Example 1:
 * [[1,1], 2, [1,1]] -> [1,1,2,1,1]
 *
 * Example 2:
 * [1,[4,[6]]] -> [1,4,6]
 */
public class NestedIterator implements Iterator<Integer> {
    // stack holds the flatten nested list
    Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    // current value
    Integer current = null;

    /**
     * initialize the stack with an iterator to the list
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            stack.push(nestedList.iterator());
        }
    }

    /**
     * Execute hasNext to check if there is a value.
     * If there is a value, then current will be set.
     * Return the current value and reset it to null.
     *
     * @return
     */
    public Integer next() {
        hasNext();

        Integer value = current;
        current = null;
        return value;
    }

    /**
     * loop through the stack until we get a NestedInteger value
     *
     * @return true if there is a value
     */
    public boolean hasNext() {
        // loop through the stack until we get a current value
        while (current == null && !stack.isEmpty()) {
            // retrieve the top value from the stack
            Iterator<NestedInteger> node = stack.peek();

            // if this node does not have a new value
            // then pop it from the stack
            if (!node.hasNext()) {
                stack.pop();
                continue;
            }

            // retrieve the next value from this iterator
            NestedInteger value = node.next();
            // if it is an NestedInteger, then set current to its value
            if (value.isInteger()) {
                current = value.getInteger();
                return true;
            } else {
                // It is a list, push it onto the stack
                stack.push(value.getList().iterator());
            }
        }
        // there are no further values to get
        return false;
    }
}