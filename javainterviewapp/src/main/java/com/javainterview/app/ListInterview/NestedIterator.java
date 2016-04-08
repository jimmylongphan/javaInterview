package com.javainterview.app.ListInterview;


/**
 * Company:
 * Google
 * 
 * Problem:
 *   Given a nested list of integers, implement an interator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may
 * also be integers or other lists.
 * 
 * Example 1:
 * [[1,1], 2, [1,1]] -> [1,1,2,1,1]
 * 
 * Example 2:
 * [1,[4,[6]]] -> [1,4,6]
 * 
 * 
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    Integer current = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if ( nestedList != null) {
            stack.push(nestedList.iterator());
        }
    }
    
    @Override
    public Integer next() {
        hasNext();
    }
}