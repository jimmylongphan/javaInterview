package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 9/26/2015.
 */
public class SortAnagramTest {

    @Test
    public void testSortPriority() {
        List<String> anagrams = Arrays.asList("dog", "cat", "god");

        SortAnagram sortAnagram = new SortAnagram();
        List<String> result = sortAnagram.sortWithPriority(anagrams);

        for (String s : result) {
            System.out.print(s + " ");
        }

        List<String> expectedResult = Arrays.asList("cat", "god", "dog");
        assertEquals(result, expectedResult);
    }

    @Test
    public void testSortPriority2() throws Exception {
        List<String> anagrams = Arrays.asList("racecar", "cat", "racecar", "tac", "act");

        SortAnagram sortAnagram = new SortAnagram();
        List<String> result = sortAnagram.sortWithPriority(anagrams);

        for (String s : result) {
            System.out.print(s + " ");
        }

        List<String> expectedResult = Arrays.asList("racecar", "racecar", "tac", "act", "cat");
        assertEquals(result, expectedResult);
    }

    @Test
    public void testSort() throws Exception {
        List<String> anagrams = Arrays.asList("dog", "cat", "god");

        SortAnagram sortAnagram = new SortAnagram();
        List<String> result = sortAnagram.sortWithMap(anagrams);

        for (String s : result) {
            System.out.print(s + " ");
        }

        List<String> expectedResult = Arrays.asList("cat", "dog", "god");
        assertEquals(result, expectedResult);
    }

    @Test
    public void testSort2() throws Exception {
        List<String> anagrams = Arrays.asList("racecar", "cat", "racecar", "tac", "act");

        SortAnagram sortAnagram = new SortAnagram();
        List<String> result = sortAnagram.sortWithMap(anagrams);

        for (String s : result) {
            System.out.print(s + " ");
        }

        List<String> expectedResult = Arrays.asList("racecar", "racecar", "cat", "tac", "act");
        assertEquals(result, expectedResult);
    }
}