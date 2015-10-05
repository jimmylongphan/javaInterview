package com.javainterview.app.ListInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/4/2015.
 */
public class CheckParenthesisTest {

    @Test
    public void testHasValidParenthesis() throws Exception {
        CheckParenthesis checkParenthesis = new CheckParenthesis();

        String s1 = "() {} []";
        String s2 = "(()) {{[()]}} []";
        String s3 = "(() {} []";
        String s4 = "() {] ]} []";

        assertTrue(checkParenthesis.hasValidParenthesis(s1));
        assertTrue(checkParenthesis.hasValidParenthesis(s2));
        assertFalse(checkParenthesis.hasValidParenthesis(s3));
        assertFalse(checkParenthesis.hasValidParenthesis(s4));
    }

}