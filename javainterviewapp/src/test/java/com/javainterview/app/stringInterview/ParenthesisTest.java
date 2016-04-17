package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created on 2/29/2016.
 */
public class ParenthesisTest {

    @Test
    public void testGenerateParenthesis() throws Exception {
        Parenthesis p = new Parenthesis();

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("()");


        List<String> results = p.generateParenthesis(1);
        Assert.assertEquals(expectedResults, results);
    }

    @Test
    public void testGenerateParenthesis2() throws Exception {
        Parenthesis p = new Parenthesis();

        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add("((()))");
        expectedResults.add("(()())");
        expectedResults.add("(())()");
        expectedResults.add("()(())");
        expectedResults.add("()()()");

        List<String> results = p.generateParenthesis(3);
        Assert.assertEquals(expectedResults, results);
    }
}