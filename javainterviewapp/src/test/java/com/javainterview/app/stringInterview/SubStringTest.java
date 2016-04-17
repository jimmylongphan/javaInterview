package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created on 2/28/2016.
 */
public class SubStringTest {

    @Test
    public void testIsSubString() throws Exception {
        String sub = "abc";
        String source = "123abc";

        SubString ss = new SubString();
        Assert.assertTrue(ss.isSubString(sub, source));
    }

    @Test
    public void testIsSubString2() throws Exception {
        String sub = "abcd";
        String source = "123abc";

        SubString ss = new SubString();
        Assert.assertFalse(ss.isSubString(sub, source));
    }
}