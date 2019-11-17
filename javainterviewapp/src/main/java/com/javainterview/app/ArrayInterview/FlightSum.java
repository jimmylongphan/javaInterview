package com.javainterview.app.ArrayInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 11/16/2019.
 */
public class FlightSum {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // determine if two movies add up to the flight length
        // map of length to count
        Set<Integer> set = new HashSet<>();
        // iterate through all movies
        for (int movieLength : movieLengths) {
            int remainder = flightLength - movieLength;
            if (set.contains(remainder)) {
                return true;
            } else {
                set.add(movieLength);
            }
        }
        return false;
    }


}
