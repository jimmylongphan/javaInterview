package com.javainterview.app.ListInterview;

import java.util.Iterator;
import java.util.List;

/**
 * Created on 12/10/2019.
 *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class NestedIterator2 implements Iterator<Integer> {
    List<NestedInteger> nestedIntegerList;
    Integer currentInteger = null;

    /**
     * Initialize the data structure
     *
     * @param nestedList original data
     */
    public NestedIterator2(List<NestedInteger> nestedList) {
        nestedIntegerList = nestedList;
    }

    @Override
    public Integer next() {
        return currentInteger;
    }

    @Override
    public boolean hasNext() {
        if (nestedIntegerList.isEmpty()) {
            return false;
        }

        boolean found = false;
        // extract the nestedInteger
        // while it is not an integer, keep extracting
        while (found == false && !nestedIntegerList.isEmpty()) {
            NestedInteger nestedInteger = nestedIntegerList.remove(0);
            // if the current value is an integer, then return that value
            if (nestedInteger.isInteger()) {
                found = true;
                currentInteger = nestedInteger.getInteger();
                break;
            }

            // while it is a list, extract and insert into beginning
            List<NestedInteger> list = nestedInteger.getList();
            for (int i = 0; i < list.size(); i++) {
                nestedIntegerList.add(i, list.get(i));
            }
        }

        return found;
    }
}

