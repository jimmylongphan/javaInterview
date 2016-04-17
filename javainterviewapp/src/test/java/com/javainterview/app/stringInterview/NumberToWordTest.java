package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/3/2015.
 */
public class NumberToWordTest {

    @Test
    public void testConvert() throws Exception {
        NumberToWord numberToWord = new NumberToWord();
        String expected = "twenty two thousand two hundred twenty two";

        String result = numberToWord.convert(22222);
        assertEquals(result, expected);
    }

    @Test
    public void testConvert2() throws Exception {
        NumberToWord numberToWord = new NumberToWord();
        String expected = "eleven thousand one hundred eleven";

        String result = numberToWord.convert(11111);
        assertEquals(result, expected);
    }
}