package com.javainterview.app.DynamicInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/6/2016.
 * Twitch
 *
 * Question:
 * Given a number of assistants and a list of file cabinets.
 * Each file cabinet may have a different size workload.
 *
 * We can only divide the cabinets contiguously for an assistant.
 * For example, the first assistant can get cabinets 1,2,3. But cannot skip and
 * get 1 and 4.
 *
 * The workload is the sum of the cabinets assigned to an assistant.
 * We want to assign the cabinets to the assistants in such a way that the
 * highest workload is the smallest possible value.
 *
 * Example: 2 assistants.  Cabinets{10, 10, 40}
 * possibilities:
 *  10 + 10, 40 -> highest is 40
 *  10, 10 + 40 -> highest is 50
 *
 * From the above, we want the workload of 40
 */
public class AssistantCabinets {

    public int getSmallestMaxWorkload(int assistants, int startIndex, List<Integer> cabinets) {
        // base case
        if (assistants == 1) {
            return getWorkload(startIndex, cabinets);
        }
        int smallestWorkload = Integer.MAX_VALUE;

        // for the current assistant
        // loop through all possible values of workloads of cabinets
        // end value for loop -> We must leave space for the remaining assistants
        // also subtract startIndex because we are truncating the cabinets
        int takingLimit = cabinets.size() - assistants - startIndex + 1;
        for (int takenCabinets=1; takenCabinets <= takingLimit; takenCabinets++) {
            int currentWorkload = getWorkloadToPosition(takenCabinets, startIndex, cabinets);

            // Now that we have our workload
            // We want the max workload of the remaining assistants and cabinets
            int maxWorkloadRemaining = getSmallestMaxWorkload(assistants-1, takenCabinets + startIndex, cabinets);

            int max = Math.max(currentWorkload, maxWorkloadRemaining);
            int min = Math.min(smallestWorkload, max);
            smallestWorkload = min;
        }

        return smallestWorkload;
    }


    /**
     * Sum all the workload up to the length in the cabinets
     * @param takenCabinets length from left to right to sum
     * @param startIndex absolute start length of cabinets
     * @param cabinets list of workable cabinets
     * @return sum
     */
    protected int getWorkloadToPosition(int takenCabinets, int startIndex, List<Integer> cabinets) {
        int workload = 0;
        for (int i=0; i<takenCabinets; i++) {
            workload += cabinets.get(startIndex + i);
        }
        return workload;
    }


    /**
     * Loop through the cabinets starting at i and add up all the workload
     *
     * @param startIndex starting position to add
     * @param cabinets the list of all cabinets
     * @return workload
     */
    protected int getWorkload(int startIndex, List<Integer> cabinets) {
        int workload = 0;
        for (int i=startIndex; i < cabinets.size(); i++) {
            workload += cabinets.get(i);
        }
        return workload;
    }

}
