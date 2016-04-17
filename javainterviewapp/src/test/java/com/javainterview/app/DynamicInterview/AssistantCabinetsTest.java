package com.javainterview.app.DynamicInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 3/6/2016.
 */
public class AssistantCabinetsTest {


    @Test
    public void testGetSmallestMaxWorkload() throws Exception {
        List<Integer> cabinets = Arrays.asList(10, 10, 40);

        AssistantCabinets ac = new AssistantCabinets();
        int min = ac.getSmallestMaxWorkload(2, 0, cabinets);

        Assert.assertEquals(min, 40);
    }


}