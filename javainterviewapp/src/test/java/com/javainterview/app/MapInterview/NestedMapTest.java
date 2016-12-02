package com.javainterview.app.MapInterview;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created on 10/4/2015.
 */
public class NestedMapTest {

    @Test
    public void testCompare() throws Exception {
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();

        String key = "key";
        map1.put(key, "a");
        // map2 is nested with map3
        map2.put(key, map3);
        // map3 contains the leaf string
        map3.put(key, "b");

        NestedMap nestedMap = new NestedMap();
        int comparison = nestedMap.compare(map1, map2, key);

        // string in map1 has a lower val
        assertEquals(comparison, -1);

        comparison = nestedMap.compare(map1, map3, key);
        assertEquals(comparison, -1);
    }

    @Test
    public void testCompare2() throws Exception {
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();

        String key = "key";
        map1.put(key, "a");
        // map2 is nested with map3
        map2.put(key, null);

        NestedMap nestedMap = new NestedMap();
        int comparison = nestedMap.compare(map1, map2, key);

        assertEquals(comparison, -1);
    }

    @Test
    public void testCompare3() throws Exception {
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        Map<String, Object> map4 = new HashMap<String, Object>();

        String key = "key";
        map1.put(key, map2);
        map2.put(key, "zzzzzz");
        map3.put(key, map4);
        map4.put(key, "aaaaaa");

        NestedMap nestedMap = new NestedMap();
        int comparison = nestedMap.compare(map1, map3, key);

        assertEquals(comparison, 25);
    }
}