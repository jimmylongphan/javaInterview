package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created on 10/6/2015.
 */
public class MedianCharTest {

    @Test
    public void testGetMedianChars() throws Exception {

        List<Character> input = Arrays.asList('a', 'b', 'b', 'c', 'c', 'e', 'e', 'e');
        MedianChar medianChar = new MedianChar();

        Set<Character> result = medianChar.getMedianChars(input);
        Set<Character> expected = new HashSet<Character>(Arrays.asList('b', 'c'));

        assertEquals(result, expected);
    }
}