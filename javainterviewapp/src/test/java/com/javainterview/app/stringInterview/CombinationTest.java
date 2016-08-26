package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 8/25/2016.
 */
public class CombinationTest {

    @Test
    public void testPrintCombinations() throws Exception {
        String input = "{Bob,Jen} went to the {park,beach} yesterday";

        List<String> result;
        Combination c = new Combination();
        result = c.printCombinations(input);

        Assert.assertEquals(result.size(), 4);
    }
}