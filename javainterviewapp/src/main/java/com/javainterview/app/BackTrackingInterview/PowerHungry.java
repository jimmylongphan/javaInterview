package com.javainterview.app.BackTrackingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 11/22/2019.
 *
 * Power Hungry
 * ============
 *
 * Commander Lambda's space station is HUGE. And huge space stations take a LOT of power.
 * Huge space stations with doomsday devices take even more power.
 * To help meet the station's power needs,
 * Commander Lambda has installed solar panels on the station's outer surface.
 * But the station sits in the middle of a quasar quantum flux field,
 * which wreaks havoc on the solar panels. You and your team of henchmen
 * have been assigned to repair the solar panels, but you'd rather not take
 * down all of the panels at once if you can help it, since they do help power
 * the space station and all!
 *
 * You need to figure out which sets of panels in any given array you
 * can take offline to repair while still maintaining the maximum amount
 * of power output per array, and to do THAT, you'll first need to figure
 * out what the maximum output of each array actually is. Write a function
 * solution(xs) that takes a list of integers representing the power output
 * levels of each panel in an array, and returns the maximum product of some
 * non-empty subset of those numbers. So for example, if an array contained
 * panels with power output levels of [2, -3, 1, 0, -5], then the maximum
 * product would be found by taking the subset: xs[0] = 2, xs[1] = -3, xs[4] = -5,
 * giving the product 2*(-3)*(-5) = 30.  So solution([2,-3,1,0,-5]) will be "30".
 *
 * Each array of solar panels contains at least 1 and no more than 50 panels,
 * and each panel will have a power output level whose absolute value is no greater
 * than 1000 (some panels are malfunctioning so badly that they're draining energy,
 * but you know a trick with the panels' wave stabilizer that lets you combine two
 * negative-output panels to produce the positive output of the multiple of their power values).
 * The final products may be very large, so give the solution as a string representation of the number.
 *
 * Languages
 * =========
 *
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit Solution.java
 *
 * Test cases
 * ==========
 * Your code should pass the following test cases.
 * Note that it may also be run against hidden test cases not shown here.
 *
 * -- Python cases --
 * Input:
 * solution.solution([2, 0, 2, 2, 0])
 * Output:
 * 8
 *
 * Input:
 * solution.solution([-2, -3, 4, -5])
 * Output:
 * 60
 *
 * -- Java cases --
 * Input:
 * Solution.solution({2, 0, 2, 2, 0})
 * Output:
 * 8
 *
 * Input:
 * Solution.solution({-2, -3, 4, -5})
 * Output:
 * 60
 */
public class PowerHungry {
    public static String solution(int[] xs) {
        Long max = findMax(xs);
        String maxStr = max.toString();
        return maxStr;
    }

    public static long findMax(int[] xs) {
        if (xs.length == 0) {
            return 0;
        }

        if (xs.length == 1) {
            return xs[0];
        }

        if (xs.length == 2) {
            long product = xs[0] * xs[1];
            long arrayMax = Math.max(xs[0], xs[1]);
            return Math.max(product, arrayMax);
        }

        List<Integer> negativePanels = new ArrayList<>();
        List<Integer> positivePanels = new ArrayList<>();

        for (int num : xs) {
            if (num < 0) {
                negativePanels.add(num);
            } else if (num > 0){
                positivePanels.add(num);
            }
        }

        if (negativePanels.size() == 1 && positivePanels.size() == 0) {
            return 0;
        }

        if (negativePanels.size() % 2 == 1) {
            Collections.sort(negativePanels);
            // remove the largest negative
            negativePanels.remove(negativePanels.size() - 1);
        }

        long product = 1;
        for (int num : negativePanels) {
            product *= num;
        }

        for (int num : positivePanels) {
            product *= num;
        }
        return product;
    }

    public static long findMaxLong(int[] xs) {
        if (xs.length == 0) {
            return 0;
        }

        if (xs.length == 1) {
            return xs[0];
        }

        if (xs.length == 2) {
            long product = xs[0] * xs[1];
            long arrayMax = Math.max(xs[0], xs[1]);
            return Math.max(product, arrayMax);
        }

        long max = xs[0];
        long min = xs[0];

        // iterate through array
        for (int i = 1; i < xs.length; i++) {
            long num = xs[i];
            long currentMax = Math.max(num, Math.max(max * num, min * num));
            long currentMin = Math.min(num, Math.min(max * num, min * num));
            max = Math.max(max, currentMax);
            min = Math.min(min, currentMin);
        }

        return max;
    }

    public static String solution_old(int[] xs) {
        List<Integer> array = new ArrayList<>();
        for (int num : xs) {
            array.add(num);
        }
        Long power = powerFinder(array, Integer.MIN_VALUE, new ArrayList<>());

        String result = power.toString();
        return result;
    }

    public static Long product(List<Integer> list) {
        Long product = new Long(1);
        for (int n : list) {
            product *= n;
        }
        return product;
    }

    private static Long powerFinder(List<Integer> array, long max, ArrayList<Integer> currentList) {
        long currentNum = PowerHungry.product(currentList);

        // update max if greater
        max = currentNum > max ? currentNum : max;

        // iterate through the current list
        for (int i = 0; i < array.size(); i++) {
            // remove from L
            Integer currentElem = array.remove(i);

            // add to current list
            currentList.add(currentElem);

            // recursive call
            max = powerFinder(array, max, currentList);

            // remove from list
            currentList.remove(currentList.size() - 1);

            // add back to L
            array.add(i, currentElem);
        }

        return max;
    }

}
