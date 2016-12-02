package com.javainterview.app.Design;


import java.util.Iterator;
import java.util.List;

/**
 * LeetCode 251
 * 
 * Company: google, Airbnb, Twitter, Zenefits
 * 
 * Tags: Design
 * 
 * Implement an iterator to flatten a 2d vector
 * 
 * Given 2d vector =
 * [
 *  [1,2],
 *  [3],
 *  [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: 
 * [1,2,3,4,5,6]
 * 
 * Hints
 * How many variables do you need to keep track?
 * 
 * Two variables is all you need. Try with x and y.
 * 
 * Beware of empty rows. It could be the first few rows.
 * 
 * To write correct code, think about the invariant to maintain. What is it?
 * 
 * The invariant is x and y must always point to a valid point in the 2d vector. 
 *      Should you maintain your invariant ahead of time or right when you need it?
 * 
 * Not sure? Think about how you would implement hasNext(). Which is more complex?
 * 
 * Common logic in two different places should be refactored into a common method.
 * 
 */
 
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> iterator;
    private Iterator<Integer> currentIter;

    /**
     * @param vec2d the original 2d vector
     * 
     */
    public Vector2D(List<List<Integer>> vec2d) {
        // initialize our main interator to the vec2d iterator
        iterator = vec2d.iterator();
    }

    /**
     * 
     * @return gets the next val in the 2d vector
     */
    @Override
    public Integer next() {
        // call to get the next element
        // since the constructor does not set current Iter, we can use this
        hasNext();
        
        // return the next val from the sub iterator
        return currentIter.next();
    }

    /**
     * 
     * @return true if our current or sub iterator has a val
     * 
     */
    @Override
    public boolean hasNext() {
        // if the current iterator is null
        // if the current iterator reached the end
        // and the main or top iterator still has values
        while ((currentIter == null || !currentIter.hasNext()) && iterator.hasNext()) {
            // set the current iterator to the next element from main
            // retrieve the iterator from that next element
            currentIter = iterator.next().iterator();
        }
        
        // return true if the current iter has a val
        return currentIter != null && currentIter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */