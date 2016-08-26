package com.javainterview.app.countInterview;

import com.javainterview.app.ArrayInterview.Interval;

import java.util.Arrays;

/**
 * Created on 9/30/2015.
 *
 * LeetCode 252
 * Company: Facebook
 * Tags: Sort
 * 
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 * 
 * Implement the comparable class to allow usage in priority queues.
 * Or any collection that uses the compareTo method
 *
 * Runtime: O(n log n) for sorting + O(n) for loop
 */
public class Meetings implements Comparable<Meetings> {
    // assuming all values are milliseconds
    public int startTime;
    public int endTime;

    /**
     * Constructor creates the meeting time in milliseconds
     *
     * @param startTime starttime in milliseconds
     * @param endTime endtime in milliseconds
     */
    public Meetings(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int compareTo(Meetings o) {
        Integer start = new Integer(this.startTime);
        Integer compareStart = new Integer(o.startTime);

        return start.compareTo(compareStart);
    }
    
    
    public boolean canAttendMeetings(Interval[] intervals) {
        // Java 8 using lambdas
        // define the comparator method
        // -1 x is less
        // 0 x is equal
        // +1 x is greater
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        
        for (int i=1; i < intervals.length; i++) {
            // check if the current end time overlaps the next start time
            if (intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }
        
        return true;
    }
}
