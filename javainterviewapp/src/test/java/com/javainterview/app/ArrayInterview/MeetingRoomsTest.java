package com.javainterview.app.ArrayInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/31/2016.
 */
public class MeetingRoomsTest {

    @Test
    public void testCanAttendMeetings() throws Exception {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 1);
        intervals[1] = new Interval(1, 2);
        intervals[2] = new Interval(3, 4);

        MeetingRooms mr = new MeetingRooms();
        boolean result = mr.canAttendMeetings(intervals);
        Assert.assertTrue(result);
    }

    @Test
    public void testCanAttendMeetings2() throws Exception {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 1);
        intervals[1] = new Interval(1, 2);
        intervals[2] = new Interval(1, 4);

        MeetingRooms mr = new MeetingRooms();
        boolean result = mr.canAttendMeetings(intervals);
        Assert.assertFalse(result);
    }
}