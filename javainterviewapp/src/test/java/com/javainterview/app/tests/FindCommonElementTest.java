package com.javainterview.app.tests;

import com.javainterview.app.ArrayInterview.FindCommonElement;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Set;

import static org.testng.Assert.*;


public class FindCommonElementTest {

    @Test
    public void testFindCommonElement() throws Exception {
        int a1[] = {1};
        int a2[] = {2, 3, 4};

        FindCommonElement findCommonElement = new FindCommonElement();
        Set<Integer> result = findCommonElement.findCommonElement(a1, a2);
        assertEquals(0, result.size());
    }

    @Test
    public void testFindCommonElement2() throws Exception {
        int a1[] = {1};
        int a2[] = {2, 3, 4, 1, 1};

        FindCommonElement findCommonElement = new FindCommonElement();
        Set<Integer> result = findCommonElement.findCommonElement(a1, a2);
        assertEquals(1, result.size());
    }

    @Test
    public void testFindCommonElement3() {
        int a1[] = {1};
        int a2[] = {2, 3, 4, 1, 1};

        FindCommonElement findCommonElement = new FindCommonElement();
        boolean result = findCommonElement.findIfCommon(a1, a2);
        assertTrue(result);
    }

    @Test
    public void testFindCommonElement4() {
        int a1[] = {1};
        int a2[] = {2, 3, 4};

        FindCommonElement findCommonElement = new FindCommonElement();
        boolean result = findCommonElement.findIfCommon(a1, a2);
        assertFalse(result);
    }
}