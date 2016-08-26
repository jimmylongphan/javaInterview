package com.javainterview.app.countInterview;

/**
 * LeetCode: none
 * Company: LinkedIn
 * Tags:
 *
 * Asked on 4/21/2016
 * Created on 8/25/2016.
 *
 */
public interface CoveredLengthIntf {

    /**
     * Adds an interval [from, to) into an internal structure.
     */
    void addInterval(int from, int to);

    /**
     * Returns a total length covered by the added intervals.
     * If several intervals intersect, the intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     (1,5),(3,6),(8,9)
     *
     * getTotalCoveredLength() -> 6
     *
     * i.e. [1,5) and [3,6) intersect and give a total covered interval [1,6) with a length of 5.
     *      [1,6) and [8,9) don't intersect, so the total covered length is a sum of both intervals, that is 5+1=6.
     *
     *          |__|__|__|                  (3,6)
     *                         |__|         (8,9)
     *    |__|__|__|__|                     (1,5)
     *
     * 0  1  2  3  4  5  6  7  8  9  10
     *
     */
    int getTotalCoveredLength();

}
