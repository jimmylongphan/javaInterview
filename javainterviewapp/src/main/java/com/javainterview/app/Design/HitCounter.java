package com.javainterview.app.DynamicInterview;



/**
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
    
    private int[] times;
    private int[] hits;
    
    /**
     * 
     * 5 minutes * 60 seconds = 300 seconds
     * Use a bucket for every second.
     * Only need 5 minutes or 300 seconds
     * 
     * The buckets and hits correlate with each other.
     */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    /**
     * Record a hit
     * 
     * @param timestamp the current timestamp (in seconds)
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        
        // if the timestamp is different, then we are outside window
        if (times[index] != timestamp) {
            // store the new timestamp
            times[index] = timestamp;
            // initialize hit to 1
            hits[index] = 1;
        } else {
            // this is the hit within the window (5 min or 300 sec)
            // increment the count
            hits[index]++;
        }
        
    }
    
    
}