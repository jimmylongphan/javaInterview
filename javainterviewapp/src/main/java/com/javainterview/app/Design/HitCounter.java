package com.javainterview.app.Design;


import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * TODO test
 * LeetCode: 362
 * Design Hit Counter
 * 
 * Company: Dropbox, Google
 * 
 * Tags: Design
 * 
 * 
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) 
 * and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * It is possible that several hits arrive roughly at the same time.
 * 
 * 
 */

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
public class HitCounter {

    private AtomicIntegerArray times;
    private AtomicIntegerArray hits;

    /**
     * 5 minutes * 60 seconds = 300 seconds
     * Use a bucket for every second.
     * Only need 5 minutes or 300 seconds
     *
     * The buckets and hits correlate with each other.
     */
    public HitCounter() {
        times = new AtomicIntegerArray(300);
        hits = new AtomicIntegerArray(300);
    }

    /**
     * Record a hit
     *
     * @param timestamp the current timestamp (in seconds)
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;

        // if the timestamp is different, then we are outside window
        if (times.get(index) != timestamp) {
            // store the new timestamp
            times.set(index, timestamp);
            // initialize hit to 1
            hits.set(index, 1);
        } else {
            // this is the hit within the window (5 min or 300 sec)
            // increment the count
            hits.incrementAndGet(index);
        }

    }

    /**
     * Return the number of hits in the past 5 minutes
     *
     * @param timestamp the current timestamp (seconds)
     * @return sum of hits
     */
    public int getHits(int timestamp) {
        int total = 0;
        // go through all the buckets
        for (int i=0; i < 300; i++) {
            // if the bucket times are within 5 minutes
            if (timestamp - times.get(i) < 300) {
                // add the hits corresponding to this bucket
                total += hits.get(i);
            }
        }
        // return the total
        return total;
    }
    
}