package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import static com.javainterview.app.stringInterview.PermutationPalindrome.hasPalindromePermutation;
import static org.testng.Assert.*;

/**
 * Created on 11/16/2019.
 */
public class PermutationPalindromeTest {
    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }


}