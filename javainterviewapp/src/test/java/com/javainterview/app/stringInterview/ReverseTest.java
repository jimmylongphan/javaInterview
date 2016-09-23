package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/30/2015.
 */
public class ReverseTest {

    @Test
    public void testReverseWords() throws Exception {
        String s = "Mary had a little";
        String expected = "little a had Mary";

        Reverse rs = new Reverse();
        String r = rs.reverseOrderOfWords(s);
        assertEquals(r, expected);
    }

    @Test
    public void testReverseSentenceByWords() throws Exception {
        String s = "Mary had a little";
        String expected = "little a had Mary";

        Reverse rs = new Reverse();
        String r = rs.reverseOrderOfWords(s);
        assertEquals(r, expected);
    }

    @Test
    public void testReverseWordsInString() throws Exception {
        String s = "Mary had a little";
        String expected = "yraM dah a elttil";

        Reverse rs = new Reverse();
        String r = rs.reverseWordsInString(s);
        assertEquals(r, expected);
    }

    @Test
    public void testReverseStringBuilder() throws Exception {
        String s = "abcdefghi";
        Reverse rs = new Reverse();

        String r = rs.reverseStringBuilder(s);
        assertEquals(r, "ihgfedcba");
    }

    @Test
    public void testReverseStringArray() throws Exception {
        String s = "abcdefghi";
        Reverse rs = new Reverse();

        String r = rs.reverseStringArray(s);
        assertEquals(r, "ihgfedcba");
    }
}