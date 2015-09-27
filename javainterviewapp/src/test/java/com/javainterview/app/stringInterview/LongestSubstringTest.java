package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/27/2015.
 */
public class LongestSubstringTest {

    @Test
    public void testMaxSubStringKUniqueChars() throws Exception {
        String input = "abcbbbbcccbdddadacb";
        String expectedOutput = "bcbbbbcccb";

        LongestSubstring longestSubstring = new LongestSubstring();
        String result = longestSubstring.maxSubStringKUniqueChars(input, 2);

        assertEquals(result, expectedOutput);
    }

    @Test
    public void testMaxSubStringKUniqueChars2() throws Exception {
        String input = "abcbbbbcccbdddadacb";
        String expectedOutput = "bcbbbbcccbddd";

        LongestSubstring longestSubstring = new LongestSubstring();
        String result = longestSubstring.maxSubStringKUniqueChars(input, 3);

        assertEquals(result, expectedOutput);
    }

    @Test
    public void testMaxSubStringKUniqueChars3() throws Exception {
        String input = "aaaaaaaaaaaaaabbbbbbbbbbbbbbb";
        String expectedOutput = "aaaaaaaaaaaaaabbbbbbbbbbbbbbb";

        LongestSubstring longestSubstring = new LongestSubstring();
        String result = longestSubstring.maxSubStringKUniqueChars(input, 2);

        assertEquals(result, expectedOutput);
    }

    @Test
    public void testMaxSubStringKUniqueChars4() throws Exception {
        String input = "aaaaaaaaaaaaaaaa";
        String expectedOutput = null;

        LongestSubstring longestSubstring = new LongestSubstring();
        String result = longestSubstring.maxSubStringKUniqueChars(input, 2);

        assertEquals(result, expectedOutput);
    }
}