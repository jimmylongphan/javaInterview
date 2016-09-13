package com.javainterview.app.BackTrackingInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/13/2016.
 */
public class RegularExpressionTest {

    @Test
    public void testIsMatch() throws Exception {
        RegularExpression re = new RegularExpression();

        assertFalse(re.isMatch("aa", "a"));
        assertTrue(re.isMatch("aa", "aa"));
        assertFalse(re.isMatch("aaa", "aa"));
        assertTrue(re.isMatch("aa", "a*"));
        assertTrue(re.isMatch("aa", ".*"));
        assertTrue(re.isMatch("ab", ".*"));
        assertTrue(re.isMatch("aab", "c*a*b"));
    }
}