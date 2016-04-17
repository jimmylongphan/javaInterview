package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/31/2016.
 */
public class ValidAnagramTest {

    @Test
    public void testIsAnagram() throws Exception {
        String s = "test";
        String t = "ttes";

        ValidAnagram va = new ValidAnagram();
        boolean result = va.isAnagram(s, t);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsAnagram2() throws Exception {
        String s = "test";
        String t = "ttea";

        ValidAnagram va = new ValidAnagram();
        boolean result = va.isAnagram(s, t);

        Assert.assertFalse(result);
    }
}