package com.javainterview.app.BackTrackingInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 12/28/2016.
 */
public class PalindromePermutation2Test {

    @Test
    public void testGeneratePalindromes() throws Exception {
        String input = "aabb";
        PalindromePermutation2 palindromePermutation2 = new PalindromePermutation2();

        List<String> result = palindromePermutation2.generatePalindromes(input);
        Assert.assertEquals(result.size(), 2);
    }
}