package com.javainterview.app.countInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 3/31/2016.
 */
public class ExcelTitleNumberTest {

    @Test
    public void testTitleToNumber() throws Exception {
        ExcelTitleNumber en = new ExcelTitleNumber();

        int num = en.titleToNumber("A");
        Assert.assertEquals(1, num);
    }

    @Test
    public void testTitleToNumber2() throws Exception {
        ExcelTitleNumber en = new ExcelTitleNumber();

        int num = en.titleToNumber("AB");
        Assert.assertEquals(28, num);
    }
}