package com.javainterview.app.countInterview;

/**
 * Created on 8/25/2016.
 */
public class CoveredLengthObj{
    public int from;
    public int to;

    public CoveredLengthObj(int f, int t) {
        this.from = f;
        this.to = t;
    }

    public int length() {
        return to - from;
    }

}
