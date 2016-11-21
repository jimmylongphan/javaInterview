package com.javainterview.app.Design;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on 11/20/2016
 *
 * Leetcode 295 Find Median from Data Stream
 *
 * Median is the middle value in an odered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle values.
 *
 * Examples:
 *
 * [2,3,4] , the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Company: Google
 * Tags: Heap, Design
 *
 */
public class MedianFinder {
    // by default priority queue is a min heap so poll gives you the smallest number
    private Queue<Integer> right = new PriorityQueue<>();

    // define our max heap by using the lambda comparator
    private Queue<Integer> left = new PriorityQueue<>(1, (Integer x, Integer y) -> (y - x));

    // Adds a number into the data structure.
    public void addNum(int num) {
        // automatically add the new number to the right side
        right.add(num);

        // then we add the smallest number to the left side
        left.add(right.poll());

        // re-balance the two sides
        if (right.size() < left.size()) {
            right.add(left.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        // if the right side is larger, then we can return the middle value
        if (right.size() > left.size()) {
           return right.peek();
        }

        // both sides are even, then we calculate the average
        double average = (right.peek() + left.peek()) / 2.0d;
        return average;
    }
}
