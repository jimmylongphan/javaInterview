package com.javainterview.app.ArrayInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 10/5/2015.
 *
 * Given an array of n integers
 * ARe there elements a,b,c, and d such that a +b +c +d = target
 *
 * Find all unique quadruplets that sum to target.
 * Elements must be ascending order.
 * no duplicates
 *
 * Runtime: O(n^3)
 */
public class FourSum {
    public List<List<Integer>> findFourSum(int[] num, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        // if there are less than 4 numbers, then the answer does not exist
        if (num.length < 4) {
            return answer;
        }

        // sort the incoming numbers
        Arrays.sort(num);

        // loop through all numbers until the 3rd from the end
        for (int i = 0; i < num.length - 3; i++) {
            // boundary check and prevent duplicates
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            // start from 1 number after i
            // then continue until the 2nd from the end
            for (int j = i + 1; j < num.length - 2; j++) {
                // j should be after i
                // prevent duplicates
                if (j > (i + 1) && num[j] == num[j - 1]) {
                    continue;
                }

                // broken down to 2 sum problem
                // keep track of indexes
                int low = j + 1;
                int high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        // this is an accepted value
                        // add the values at i and j and low and high
                        answer.add(Arrays.asList(num[i], num[j], num[low], num[high]));

                        // increment low index and prevent duplicates
                        while (low < high && num[low] == num[low + 1]) {
                            low++;
                        }

                        // decrement high index and prevent duplicates
                        while (low < high && num[high] == num[high - 1]) {
                            high--;
                        }

                        // move the low index to the different number
                        low++;

                        // move the high index lower to the different number
                        high--;

                    } else if (sum < target) {
                        // sum is too small
                        // increment the low value
                        low++;
                    } else {
                        // sum is too large
                        // decrement the high value
                        high--;
                    }
                }
            }
        }

        return answer;

    }
}

