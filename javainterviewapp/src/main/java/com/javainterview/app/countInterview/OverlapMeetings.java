package com.javainterview.app.countInterview;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created on 9/30/2015.
 *
 * You have a lot of meetings with startTime and endTime, both integer,
 * Given a minute in day, return if you have overlapped meeting at this time.
 */
public class OverlapMeetings {

    public static int MILLI_IN_MIN = 60000;

    /**
     * Put all meetings in a priority queue to allow natural ordering.
     *
     * Then check two meetings at a time to see overlap.
     *
     * Runtime: O(n) go through every meeting and check
     *
     * @param meetings     list of meetings to check
     * @param timeInMinute the time in minutes
     * @return true if overlap
     */
    public boolean findOverlap(List<Meetings> meetings, int timeInMinute) {
        // first convert the timeInMinutes to milliseconds
        int timeInMillis = timeInMinute * MILLI_IN_MIN;

        // put all meetings into the priority queueu
        PriorityQueue<Meetings> orderedMeetings = new PriorityQueue<Meetings>(meetings);

        // go through all meetings two at a time
        // check if the startTime of the second is earlier than the endTime of the first
        Meetings currentMeeting = orderedMeetings.poll();
        Meetings nextMeeting = orderedMeetings.poll();
        while (nextMeeting != null) {
            // check if we are in the boundary of the time
            if (currentMeeting.endTime < timeInMillis ||
                    nextMeeting.startTime > timeInMillis) {
                // invalid we can skip
                // move the meetings over
                currentMeeting = nextMeeting;
                nextMeeting = orderedMeetings.poll();
                continue;
            }

            // the minute is within the boundary
            // check if the meetings overlap
            if (currentMeeting.endTime > nextMeeting.startTime) {
                return true;
            }

            // move the meetings over
            currentMeeting = nextMeeting;
            nextMeeting = orderedMeetings.poll();
        }

        // no overlaps found
        return false;
    }
}
