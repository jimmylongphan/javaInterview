package com.javainterview.app.ListInterview;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * LeetCode 186
 *
 * Created on 11/14/2019.
 */
public class ReverseWordsTest {

    @Test
    public void testReverse_words() {
        List<Character> input = Arrays.asList('c', 'a', 'k', 'e', ' ', 'f', 'o', 'o', ' ', 'b', 'a', 'r');
        System.out.println(input);

        ReverseWords.reverse_words(input);
        System.out.println(input);
    }
}
