package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 9/30/2015.
 */
public class OverlapMeetingsTest {

    @Test
    public void testFindOverlap() throws Exception {
        List<Meetings> meetings = Arrays.asList(
                new Meetings(0, 100),
                new Meetings(200, 300),
                new Meetings(350, 500)
        );

        OverlapMeetings overlapMeetings = new OverlapMeetings();
        boolean exists = overlapMeetings.findOverlap(meetings, 10);
        assertFalse(exists);
    }

    @Test
    public void testFindOverlap2() throws Exception {
        List<Meetings> meetings = Arrays.asList(
                new Meetings(0, 100),
                new Meetings(50, 300),
                new Meetings(350, 500)
        );

        OverlapMeetings overlapMeetings = new OverlapMeetings();
        boolean exists = overlapMeetings.findOverlap(meetings, 75);
        assertTrue(exists);
    }

    @Test
    public void testFindOverlap3() throws Exception {
        List<Meetings> meetings = Arrays.asList(
                new Meetings(0, 100),
                new Meetings(200, 300),
                new Meetings(350, 500)
        );

        OverlapMeetings overlapMeetings = new OverlapMeetings();

        // current time is too late
        boolean exists = overlapMeetings.findOverlap(meetings, 600);
        assertFalse(exists);
    }

    @Test
    public void testFindOverlapBitMap() throws Exception {
        List<Meetings> meetings = Arrays.asList(
                new Meetings(0, 100),
                new Meetings(50, 300),
                new Meetings(350, 500)
        );

        OverlapMeetings overlapMeetings = new OverlapMeetings();
        boolean exists = overlapMeetings.findOverlapBitMap(meetings, 75);
        assertTrue(exists);
    }

    @Test
    public void testFindOverlapBitMap2() throws Exception {
        List<Meetings> meetings = Arrays.asList(
                new Meetings(0, 100),
                new Meetings(150, 300),
                new Meetings(350, 500)
        );

        OverlapMeetings overlapMeetings = new OverlapMeetings();
        boolean exists = overlapMeetings.findOverlapBitMap(meetings, 75);
        assertFalse(exists);
    }
}