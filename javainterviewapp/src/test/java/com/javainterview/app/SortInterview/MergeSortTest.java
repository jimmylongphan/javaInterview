package com.javainterview.app.SortInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 2/22/2016.
 */
public class MergeSortTest {

    @Test
    public void testMergeSort() throws Exception {
        int[] testArray = {4,7,1,9,3};

        MergeSort ms = new MergeSort();
        ms.mergeSort(testArray, 0, testArray.length-1);

        int[] finalArray = {1,3,4,7,9};
        Assert.assertEquals(testArray, finalArray);

    }
}