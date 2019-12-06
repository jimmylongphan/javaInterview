package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static com.javainterview.app.ArrayInterview.ArrayBinarySearch.findRotationPoint;
import static org.testng.Assert.*;

/**
 * Created on 11/24/2019.
 */
public class ArrayBinarySearchTest {

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[]{"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[]{"grape", "orange", "plum",
                "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
                new String[]{"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                        "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

}