package com.javainterview.app.ListInterview;

import java.lang.reflect.Array;
import java.util.*;

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

    public RateLimiting(int maxRequest, int timeLimitSeconds) {
        this.fitBitArray = new Long[maxRequest+1];
        this.fitBitTimeLimit = timeLimitSeconds * 1000;
        this.fitBitArrayIndex = 0;
    }

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

    private Long[] fitBitArray;
    private int fitBitTimeLimit;
    private int fitBitArrayIndex;

    /**
     * Idea: use a fixed size array for requests. This index will wrap around. The next index will be the previous
     * max requests.  If the time limit is within our limit, then success.
     *
     * @return true if we can process
     */
    public boolean fitBitRequest() {
        long currentTime = System.currentTimeMillis();

        if (currentTime - fitBitArray[fitBitArrayIndex] < fitBitTimeLimit) {
            return false;
        }

        // can still process the request
        fitBitArray[fitBitArrayIndex++] = currentTime;
        if (fitBitArrayIndex >= fitBitArray.length) {
            // wrap the index around
            fitBitArrayIndex = 0;
        }
        return true;
    }
}
