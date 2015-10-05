package com.javainterview.app.ListInterview;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 10/4/2015.
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

}
