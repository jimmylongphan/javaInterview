package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 9/28/2015.
 */
public class SegmentTest {

    @Test
    public void testSegment() throws Exception {
        String s = "This is the super long test string that was used at an interview at Twilio. They"
                + " wanted to see if we can segment this string for Twitter length sized messages.";

        Segmenter segmenter = new Segmenter();
        List<String> segments = segmenter.segment(s, 140);

        assertEquals(segments.size(), 2);
    }

    @Test
    public void testSegment2() throws Exception {
        String s = "This is the super long test string that was used at an interview at Twilio. They"
                + " wanted to see if we can segment this string for Twitter length sized messages.";

        Segmenter segmenter = new Segmenter();
        List<String> segments = segmenter.segment(s, 10);

        assertEquals(segments.size(), 19);
    }

    @Test
    public void testSegment3() throws Exception {
        String s = "This is the super long test string that was used at an interview at Twilio. They"
                + " wanted to see if we can segment this string for Twitter length sized messages.";

        Segmenter segmenter = new Segmenter();
        List<String> segments = segmenter.segment(s, 1);

        // nothing fits in the segment size
        assertEquals(segments.size(), 0);
    }

    @Test
    public void testSegment4() throws Exception {
        String s = "This is the super long test string that was used at an interview at Twilio. They"
                + " wanted to see if we can segment this string for Twitter length sized messages.";

        Segmenter segmenter = new Segmenter();
        List<String> segments = segmenter.segment(s, 3);

        // nothing fits in the segment size
        assertEquals(segments.size(), 0);
    }
}