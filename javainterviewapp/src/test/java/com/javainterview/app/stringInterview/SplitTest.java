package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 3/6/2016.
 */
public class SplitTest {

    @Test
    public void testSplit() throws Exception {
        String input = "abcdef";
        List<String> delimiters = Arrays.asList("bc", "e");

        Split s = new Split();
        List<String> result = s.split(input, delimiters);

        List<String> expectedResult = Arrays.asList("a", "d", "f");

        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testSplit2() throws Exception {
        String input = "jackandjill";
        List<String> delimiters = Arrays.asList("and");

        Split s = new Split();
        List<String> result = s.split(input, delimiters);

        List<String> expectedResult = Arrays.asList("jack", "jill");

        Assert.assertEquals(result, expectedResult);
    }
}