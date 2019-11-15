package com.javainterview.app.BackTrackingInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 294
 *
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and
 * therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 * For example, given s = "++++", return true.
 * The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 *
 * Follow up:
 * Derive your algorithm's runtime complexity.
 *
 * Created on 12/29/2016.
 *
 * Runtime complexity:
 * Without the hashset memoization
 * Double factorial?
 * Only in cases where the factorial is for all even or all odd
 *
 * (n - 1) * (n - 3) * (n - 5)
 * n!!
 *
 *
 */
public class FlipGame {

    public boolean canWin(String s) {
        // guaranteed loss
        if (s == null || s.length() < 2) {
            return false;
        }

        // memoize all string values where you win
        Set<String> winSet = new HashSet<>();
        boolean result = canWinHelper(s, winSet);

        return result;
    }

    private boolean canWinHelper(String s, Set<String> winSet) {
        // base case
        if (winSet.contains(s)) {
            // already calculated you can win
            return true;
        }

        // iterate
        for (int i=0; i < s.length() - 1; i++) {
            // if we can flip at the current position
            if (s.indexOf("++", i) == i) {
                // pick our move
                // transform the input
                // prefix is from 0 to the pick, exclusive
                // add the flip characters
                // suffix is string after the flip position
                String current = s.substring(0, i) + "--" + s.substring(i+2);

                // DFS recursive call with the transformed string
                // only if the other opponent cannot win with this move,
                // then it is our winning move
                if (!canWinHelper(current, winSet)) {
                    // add our winning move to the set
                    winSet.add(s);
                    // we can we so return true
                    return true;
                }
            }
        }

        // we never found a move where we can win
        return false;
    }

}
