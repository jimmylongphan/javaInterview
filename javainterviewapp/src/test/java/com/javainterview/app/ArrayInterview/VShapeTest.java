package com.javainterview.app.ArrayInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/26/2015.
 */
public class VShapeTest {

    @Test
    public void testFindMin() throws Exception {
        int a[] = {9, 5, 2, 1, -1, 3, 6, 8};
        VShape vShape = new VShape();
        int min = vShape.findMin(a);
        assertEquals(-1, min);
    }

    @Test
    public void testFindMin2() throws Exception {
        int a[] = {9, 5, 2, 1};
        VShape vShape = new VShape();
        int min = vShape.findMin(a);
        assertEquals(1, min);
    }

    @Test
    public void testFindMin3() throws Exception {
        int a[] = {-1, 3, 6, 8};
        VShape vShape = new VShape();
        int min = vShape.findMin(a);
        assertEquals(-1, min);
    }
}