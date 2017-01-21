package com.javainterview.app.BackTrackingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 93
 *
 * Tags: Backtracking
 *
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class RestoreIP {

    public List<String> restoreIpAddresses(String s) {
        List<String> solution = new ArrayList<>();
        restoreIpAddressesHelper(s, solution, "", 0, 0);
        return solution;
    }

    public void restoreIpAddressesHelper(String s, List<String> solution, String current, int index, int sectionNum) {
        // cannot have more than 4 sections so we will return
        if (sectionNum > 4) {
            return;
        }

        // reached the end of the sections and the original input
        // add our current value
        if (sectionNum == 4 && index == s.length()) {
            solution.add(current);
        }

        // loop through possible lengths of a section to build the ip
        // sections must be between 1 and 3 length
        for (int sectionLength = 1; sectionLength <= 3; sectionLength++) {
            // the length goes past the original input
            // boundary check
            if (index + sectionLength > s.length()) {
                break;
            }

            // create a substring for the current section
            String sub = s.substring(index, index + sectionLength);

            // section cannot start with 0 so we continue
            if (sub.startsWith("0") && sub.length() > 1) {
                continue;
            }

            // section cannot be more than 255
            if (sectionLength == 3 && Integer.parseInt(sub) >= 256) {
                continue;
            }

            // build our new substring
            // the current section combined with the new substring
            // if there are more sections then add the dot
            String current2 = current + sub + (sectionNum < 3 ? "." : "");

            // the section has valid number
            // recursive call for next sections
            restoreIpAddressesHelper(s, solution, current2, index + sectionLength, sectionNum + 1);
        }
    }
}
