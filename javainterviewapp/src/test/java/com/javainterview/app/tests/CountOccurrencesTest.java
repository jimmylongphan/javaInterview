package com.javainterview.app.tests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.javainterview.app.countInterview.CountOccurrences;

public class CountOccurrencesTest {

    CountOccurrences countOccurrences;

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("testBeforeSuite() creating countOccurrences");
        countOccurrences = new CountOccurrences();
    }

    @Test
    public void checkThree() {
        int[] input = {3, 3, 3};
        assertTrue(countOccurrences.hasNOccurrences(input, 3));
    }

    @Test
    public void checkFiveFail() {
        int[] input = {1};
        assertFalse(countOccurrences.hasNOccurrences(input, 5));
    }

    @Test
    public void checkConsecutive() {
        int[] input = {1,2,3};
        assertTrue(countOccurrences.hasNConsecutive(input,3));
    }

    @Test
    public void checkConsecutive2() {
        int[] input = {1,1,1};
        assertFalse(countOccurrences.hasNConsecutive(input, 1));
    }

    @Test
    public void checkConsecutive3() {
        int[] input = {1,1,1,5,6,7,8,9,9,9};
        assertTrue(countOccurrences.hasNConsecutive(input,5));
    }
}