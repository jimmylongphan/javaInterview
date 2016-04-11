package com.javainterview.app.ListInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * Company: LinkedIn, Google
 *
 * Implementation of the NestedInteger interface
 */
public class NestedInteger implements NestedIntegerIntf {
    public List<Object> values;

    public NestedInteger() {
        values = new LinkedList<Object>();
    }

    public NestedInteger(Integer i) {
        values = new LinkedList<Object>();
        values.add(i);
    }

    public NestedInteger(List<NestedInteger> list) {
        values = new LinkedList<Object>();
        values.add(list);
    }

    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    public boolean isInteger() {
        if (values.size() == 1) {
            // size is 1
            // check type of object in list
            return values.get(0) instanceof Integer;
        }

        // not desired value
        return false;
    }

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    public Integer getInteger() {
        // check if we can actually get the value
        if (!isInteger()) {
            return null;
        }

        // it is possible to get the value
        return (Integer) values.get(0);
    }

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer
     */
    public List<NestedInteger> getList() {
        // It holds a single integer
        if (isInteger()) {
            return null;
        }

        // loop through the list
        for (Object o : values) {
            if (o instanceof List) {
                return (List) o;
            }
        }

        return null;
    }
}