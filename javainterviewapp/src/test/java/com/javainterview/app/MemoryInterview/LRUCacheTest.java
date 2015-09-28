package com.javainterview.app.MemoryInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/27/2015.
 */
public class LRUCacheTest {

    @Test
    public void testAdd() {
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(10);

        lruCache.add("test", 1);
        Node node = lruCache.get("test");
        assertEquals(node.getValue(), 1);
    }

    @Test
    public void testNullGet() {
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(10);

        Node node = lruCache.get("test");
        assertNull(node);
    }

    @Test
    public void testFull() {
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(3);

        lruCache.add("test1", 1);
        lruCache.add("test2", 2);
        lruCache.add("test3", 3);

        // should be full
        assertTrue(lruCache.isFull());

        lruCache.add("test4", 4);
        // test1 should be removed
        Node node1 = lruCache.get("test1");
        assertNull(node1);

        // test4 should exist
        Node node4 = lruCache.get("test4");
        assertEquals(node4.getValue(), 4);
    }


}