package com.javainterview.app.stringInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created on 4/16/2016.
 */
public class ShortestDistanceTest {

    @Test
    public void testShortestDistance() throws Exception {
        ShortestDistance sd = new ShortestDistance();
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};

        int distance = sd.shortestDistance(words, "coding", "practice");
        Assert.assertEquals(distance, 3);
    }

    @Test
    public void testShortestDistance2() throws Exception {
        ShortestDistance sd = new ShortestDistance();
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};

        int distance = sd.shortestDistance(words, "makes", "coding");
        Assert.assertEquals(distance, 1);
    }

    @Test
    public void testShortestDistanceOptimum() throws Exception {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        ShortestDistance sd = new ShortestDistance(words);

        int distance = sd.shortestDistanceOptimum("coding", "practice");
        Assert.assertEquals(distance, 3);
    }

    @Test
    public void testShortestDistanceOptimum2() throws Exception {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        ShortestDistance sd = new ShortestDistance(words);

        int distance = sd.shortestDistanceOptimum("makes", "coding");
        Assert.assertEquals(distance, 1);
    }

    @Test
    public void testShortestWordDistanceSame() throws Exception {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        ShortestDistance sd = new ShortestDistance();

        int distance = sd.shortestWordDistanceSame(words, "makes", "makes");
        Assert.assertEquals(distance, 3);
    }
}