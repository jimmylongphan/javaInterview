package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 4/10/2016.
 */
public class LetterCombinationsPhoneTest {

    @Test
    public void testLetterCombinations() throws Exception {

        String digits = "23";
        List<String> expectedResults = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        LetterCombinationsPhone lcp = new LetterCombinationsPhone();
        List<String> result = lcp.letterCombinations(digits);
        Assert.assertEquals(result, expectedResults);
    }
}