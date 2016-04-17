package com.javainterview.app.countInterview;

/**
 * Created on 9/30/2015.
 *
 * Implement the comparable class to allow usage in priority queues.
 * Or any collection that uses the compareTo method
 *
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
}
