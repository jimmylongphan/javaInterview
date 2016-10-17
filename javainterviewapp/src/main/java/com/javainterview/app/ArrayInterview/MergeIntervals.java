package com.javainterview.app.ArrayInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 56 Merge Intervals
 *
 * Company: All,
 * Tags: Array, Sort
 *
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]
 *
 *
 *
 * Created on 10/16/2016.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        // edge cases
        if (intervals.size() <= 1) {
            return intervals;
        }

        // sort all intervals first
        Collections.sort(intervals, (Interval x, Interval y) -> x.start - y.start);

        List<Interval> result = new ArrayList<>();
        Interval previousInterval = intervals.get(0);
        Interval currentInterval = null;

        for (int i=1; i < intervals.size(); ++i) {
            currentInterval = intervals.get(i);
            if (currentInterval.start <= previousInterval.end) {
                // merge intervals
                Interval merge = new Interval(previousInterval.start,
                        Math.max(previousInterval.end, currentInterval.end));
                previousInterval = merge;
            } else {
                // add the previous into our result
                result.add(previousInterval);
                previousInterval = currentInterval;
            }
        }

        // handle last case
        result.add(previousInterval);

        return result;
    }
}
