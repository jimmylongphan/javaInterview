package com.javainterview.app.countInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 346
 * Moving Average from Data Stream
 *
 * Company: Google
 * Tags: Design Queue
 *
 * Given a stream of integers and a window size, calculate the
 * moving average of all integers in the sliding window.
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 *
 * Solution:
 * Keep track of the sum of the current window as we go.
 * If we need to remove a number, just subtract the number from
 * sum and divide by size.
 *
 * Runtime: O(1)
 * Space: O(size)
 */


public class MovingAverage {
    private double previousSum = 0.0;
    private int maxSize;
    private Queue<Integer> currentWindow;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        currentWindow = new LinkedList<Integer>();
        maxSize = size;
    }

    public double next(int val) {
        if (currentWindow.size() == maxSize) {
            // First in First out so we remove the oldest number
            previousSum -= currentWindow.remove();
        }

        // add the new value
        previousSum += val;

        // insert into our queue
        currentWindow.add(val);

        // return the average
        return previousSum / currentWindow.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */