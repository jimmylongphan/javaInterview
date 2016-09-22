package com.javainterview.app.ListInterview;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode: 359
 * Company: Google
 * Tags: Hash Table, Design
 * 
 * Created on 10/4/2015.
 * 
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 * 
 * Solution:
 * Store when it is ok to print log again.
 * 
 */
public class RateLimiting {

    /**
     *
     */
    public void getRequest() {
        Queue<Date> dates = new LinkedList<Date>();
        Date current = new Date();
        dates.add(current);

        if( dates.size() > 5) {
            Date head = dates.poll();
            long diff = current.getTime() - head.getTime();
            long seconds = diff / 1000;
            if( seconds < 1) {
                return;
            }
        }
    }

    // leetCode 359
    // key: log message
    // value: when it is ok to log message timestamp 
    private Map<String, Integer> ok = new HashMap<>();


    /**
     * LeetCode 359
     * Limiting each message to be within a timeframe
     * 
     * @param timestamp the current timestamp
     * @message the pre-defined log message
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // within the 10 second mark
        // do not return
        // if no entry, then default is 0 and timestamp will be greater
        if (timestamp < ok.getOrDefault(message, 0)) {
            return false;
        }
        
        // add message with new timestamp limit
        ok.put(message, timestamp + 10);
        return true;
    }
    
}
