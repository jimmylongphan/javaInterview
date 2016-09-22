package com.javainterview.app.MemoryInterview;

import com.javainterview.app.ListInterview.DoubleLinkedNode;
import com.javainterview.app.ListInterview.Node;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/27/2015.
 */
public class LRUCacheTest {

    @Test
    public void testAdd() {
        LRUCache lruCache = new LRUCache(10);

        lruCache.set(0, 1);
        assertEquals(lruCache.get(0), 1);
    }

    @Test
    public void testNullGet() {
        LRUCache lruCache = new LRUCache(10);
        assertEquals(lruCache.get(0), -1);
    }

    @Test
    public void testFull() {
        LRUCache lruCache = new LRUCache(3);

        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);

        // should be full
        assertTrue(lruCache.isFull());

        lruCache.set(4, 4);
        // 1 should be removed
        assertEquals(lruCache.get(1), -1);

        // 4 should exist
        assertEquals(lruCache.get(4), 4);
    }

}