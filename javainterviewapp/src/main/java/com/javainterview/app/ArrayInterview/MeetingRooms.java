package com.javainterview.app.ArrayInterview;

/**
 * Company: Facebook
 * 
 * Given an array of meeting time intervals with start and end times
 * [[s1,e1], [s2,e2]...]
 * 
 * Determine if a person can attend all meetings
 * 
 * [[0,30], [5,10], [15,20]]
 * return false
 * 
 * Solution:
 *   First sort the array of intervals.
 *   To sort the custom class, we will create a new comparator method
 *   that compares the start times of the entries.
 *   O(n log n)
 * 
 *   Then we will loop through every entry starting at index 1
 *   If any of the previous end times are greater than the current index
 *   start time, then it is false.
 *   O(n)
 * 
 *   If no overlaps found, then it is true
 */ 
 
public class MeetingRooms {
 
    public boolean canAttendMeetings( Interval[] intervals ) {
        if (intervals == null) {
            return false;
        }
        
        // sort the intervals by start time
        // O(n log n)
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        // loop through array and check if any start times overlap
        // with the previous end time
        for (int i=1; i < intervals.length; i++) {
            if( intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        
        // no overlaps found
        return true;
    }   
 
}