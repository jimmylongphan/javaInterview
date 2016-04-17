package com.javainterview.app.countInterview;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created on 10/3/2015.
 */
public class HappyNumbersTest {

    @Test
    public void testIsHappy() throws Exception {
        HappyNumbers happyNumbers = new HappyNumbers();

        boolean happy = happyNumbers.isHappy(1);
        assertTrue(happy);
    }

    @Test
    public void testIsHappy2() throws Exception {
        HappyNumbers happyNumbers = new HappyNumbers();

        boolean happy = happyNumbers.isHappy(19);
        assertTrue(happy);
    }

    @Test
    public void testIsHappy3() {
        HappyNumbers happyNumbers = new HappyNumbers();
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> expected = Arrays.asList(1, 7, 10, 13, 19, 23, 28, 31);

        for (int i = 1; i < 32; i++) {
            boolean happy = happyNumbers.isHappy(i);
            if (happy) {
                System.out.print(i + ' ');
                result.add(i);
            }
        }

        assertEquals(result, expected);
    }


}