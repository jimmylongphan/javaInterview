package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/16/2016.
 */
public class ShortestPalindromeTest {

    @Test
    public void testShortestPalindrome() throws Exception {
        String input = "abcd";

        ShortestPalindrome sp = new ShortestPalindrome();
        String result = sp.shortestPalindrome(input);

        Assert.assertEquals(result, "dcbabcd");
    }

    @Test
    public void testShortestPalindrome2() throws Exception {
        String input = "aaba";

        ShortestPalindrome sp = new ShortestPalindrome();
        String result = sp.shortestPalindrome(input);

        Assert.assertEquals(result, "abaaba");
    }
}