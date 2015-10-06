package com.javainterview.app.MapInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/6/2015.
 */
public class TimeHashMapTest {

    @Test
    public void testGet() throws Exception {
        TimeHashMap timeHashMap = new TimeHashMap();
        timeHashMap.insert("k1", "v1", 10);

        String val = timeHashMap.get("k1");
        assertEquals(val, "v1");

        val = timeHashMap.get("k1", 11);
        assertEquals(val, "v1");
    }

    @Test
    public void testGet1() throws Exception {
        TimeHashMap timeHashMap = new TimeHashMap();
        timeHashMap.insert("k1", "v1", 10);
        timeHashMap.insert("k1", "v2", 20);

        String val = timeHashMap.get("k1", 15);
        assertEquals(val, "v1");

        val = timeHashMap.get("k1", 11);
        assertEquals(val, "v1");

        val = timeHashMap.get("k1", 21);
        assertEquals(val, "v2");
    }
}