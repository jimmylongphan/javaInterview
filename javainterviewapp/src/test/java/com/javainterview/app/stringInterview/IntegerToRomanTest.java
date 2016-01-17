package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 1/16/2016.
 */
public class IntegerToRomanTest {

    @Test
    public void testConvert() throws Exception {
        int num = 50;
        IntegerToRoman toRoman = new IntegerToRoman();
        String result = toRoman.convert(num);
        assertEquals(result, "L");
    }

    @Test
    public void testConvert2() throws Exception {
        int num = 1984;
        IntegerToRoman toRoman = new IntegerToRoman();
        String result = toRoman.convert(num);
        assertEquals(result, "MCMLXXXIV");
    }
}