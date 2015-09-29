package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

/**
 * Created on 9/28/2015.
 */
public class DictionaryTrimmerTest {

    @Test
    public void testSegment() throws Exception {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>(
                Arrays.asList("leet", "code")
        );

        DictionaryTrimmer dictionaryTrimmer = new DictionaryTrimmer();
        List<String> segments = new ArrayList<String>();

        boolean result = dictionaryTrimmer.segment(s, dict, segments);
        assertTrue(result);
        assertEquals(segments.size(), 2);
    }

    @Test
    public void testSegment2() throws Exception {
        String s = "leetcodesuper";
        Set<String> dict = new HashSet<String>(
                Arrays.asList("leet", "code")
        );

        DictionaryTrimmer dictionaryTrimmer = new DictionaryTrimmer();
        List<String> segments = new ArrayList<String>();

        boolean result = dictionaryTrimmer.segment(s, dict, segments);
        assertFalse(result);
        assertEquals(segments.size(), 0);
    }
}