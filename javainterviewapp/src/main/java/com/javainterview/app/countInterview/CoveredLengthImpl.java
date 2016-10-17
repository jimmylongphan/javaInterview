package com.javainterview.app.countInterview;

import java.util.*;

/**
 * Created on 8/25/2016.
 */
public class CoveredLengthImpl implements CoveredLengthIntf {

    List<CoveredLengthObj> intervalList;

    public CoveredLengthImpl() {
        intervalList = new ArrayList<>();
    }

    @Override
    public void addInterval(int from, int to) {
        // insert a new object that contains from and to
        intervalList.add(new CoveredLengthObj(from, to));
    }

    @Override
    public int getTotalCoveredLength() {
        int length = 0;

        // explicitly sort the priority queue before iterating
        // using lambdas to define comparator method for the objects
        Collections.sort(intervalList, (CoveredLengthObj x, CoveredLengthObj y) -> x.from - y.from);

        Iterator it = intervalList.iterator();
        CoveredLengthObj previous = (CoveredLengthObj) it.next();
        CoveredLengthObj current;

        // loop through all intervals
        while (it.hasNext()) {
            // get current interval
            current = (CoveredLengthObj) it.next();

            if (current.from <= previous.to) {
                // intervals overlap so create a new previous
                previous = new CoveredLengthObj(previous.from,
                        Math.max(previous.to, current.to));
            } else {
                // intervals do not overlap
                // update the length with previous
                length += previous.length();

                // set previous to the current
                previous = current;
            }
        }

        // add the very last interval
        length += previous.length();

        return length;
    }

}
