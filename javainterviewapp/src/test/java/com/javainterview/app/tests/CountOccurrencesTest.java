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
	    int[] input = { 3, 3, 3 };
	    assertTrue(countOccurrences.hasNOccurrences(input, 3));
	}
	
	@Test
	public void checkFiveFail() {
	    int[] input = { 1 };
	    assertFalse(countOccurrences.hasNOccurrences(input, 5));
	}
}