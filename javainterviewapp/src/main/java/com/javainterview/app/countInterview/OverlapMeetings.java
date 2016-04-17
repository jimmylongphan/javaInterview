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

    public static int MIN_IN_DAY = 1440;
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
        int timeInMillis = timeInMinute;

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


    /**
     * Check if the time is in between the meetings from the list.
     * If it is in between, then fill in the bitmap with true values from the
     * range in the meetings.
     *
     * Meetings are the minutes of the day in start time and end time.
     *
     * @param meetings
     * @param timeInMinute
     * @return
     */
    public boolean findOverlapBitMap(List<Meetings> meetings, int timeInMinute) {
        int[] countMap = new int[MIN_IN_DAY];

        // loop through all meetings
        for (Meetings meeting : meetings) {
            // check if time is in between meetings
            if (timeInMinute >= meeting.startTime && timeInMinute <= meeting.endTime) {
                for (int i = meeting.startTime; i <= meeting.endTime; i++) {
                    // set all values in bitmap to greater than zero
                    // if it is already set, then we know there is an overlap
                    if (countMap[i] > 0) {
                        return true;
                    } else {
                        countMap[i] = countMap[i] + 1;
                    }
                }
            }
        }

        return false;
    }

}
