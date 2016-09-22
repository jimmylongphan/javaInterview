package com.javainterview.app.stringInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/28/2015.
 */
public class IsomorphicTest {

    @Test
    public void testisIsomorphic() throws Exception {
        String s1 = "rat";
        String s2 = "tar";

        Isomorphic isomorphic = new Isomorphic();
        boolean isIso = isomorphic.isIsomorphic(s1, s2);
        assertTrue(isIso);
    }

    @Test
    public void testAreIso() throws Exception {
        String s1 = "rat";
        String s2 = "tar";

        Isomorphic isomorphic = new Isomorphic();
        boolean isIso = isomorphic.isIsomorphicEncoding(s1, s2);
        assertTrue(isIso);
    }

    @Test
    public void testAreIso2() throws Exception {
        String s1 = "foo";
        String s2 = "bar";

        Isomorphic isomorphic = new Isomorphic();
        boolean isIso = isomorphic.isIsomorphicEncoding(s1, s2);
        assertFalse(isIso);
    }

    @Test
    public void testAreIsoHash() throws Exception {
        String s1 = "rat";
        String s2 = "tar";

        Isomorphic isomorphic = new Isomorphic();
        boolean isIso = isomorphic.areIsoHash(s1, s2);
        assertTrue(isIso);
    }

    @Test
    public void testAreIsoHash2() throws Exception {
        String s1 = "abcdefg";
        String s2 = "hijklmh";

        Isomorphic isomorphic = new Isomorphic();
        boolean isIso = isomorphic.areIsoHash(s1, s2);
        assertFalse(isIso);
    }

    @Test
    public void testAreIsoHash3() throws Exception {
        String s1 = "abcdefgabcdefg";
        String s2 = "hijklmohijklmo";

        Isomorphic isomorphic = new Isomorphic();
        boolean isIso = isomorphic.areIsoHash(s1, s2);
        assertTrue(isIso);
    }
}