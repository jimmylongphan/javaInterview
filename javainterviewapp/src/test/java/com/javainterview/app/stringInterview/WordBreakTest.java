package com.javainterview.app.stringInterview;

import com.beust.jcommander.internal.Sets;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created on 3/20/2016.
 */
public class WordBreakTest {

    @Test
    public void testWordBreak() throws Exception {
        List<String> words = Arrays.asList("leet", "code");
        Set<String> dictionary = new HashSet<String>(words);
        String test = "leetcode";

        WordBreak wb = new WordBreak();
        List<String> result = wb.wordBreak2(test, dictionary);
        Assert.assertEquals(result, words);
    }
}