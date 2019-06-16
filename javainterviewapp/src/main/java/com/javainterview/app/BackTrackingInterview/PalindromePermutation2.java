package com.javainterview.app.BackTrackingInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 267
 *
 * Tags: Backtracking
 *
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 *
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 *
 * Created on 12/28/2016.
 */
public class PalindromePermutation2 {

    public List<String> generatePalindromes(String s) {
        List<String> result = new LinkedList<>();

        // keep track of how many characters have odd counts
        int numOddCounts = 0;

        // map of character to frequency
        // the position is the char, the value is the count
        int[] charCount = new int[256];

        // validate if we can support palindromes
        // based on how many odd characters there are
        for (char c : s.toCharArray()) {
            // update the array with the count
            charCount[c]++;

            // if the value of at this location is odd, then increment, else decrement
            numOddCounts = (charCount[c] % 2) == 1 ? numOddCounts + 1 : numOddCounts - 1;
        }

        System.out.println("numOddCounts: " + numOddCounts);

        // IMPORTANT
        // cannot have more than one odd char
        if (numOddCounts > 1) {
            return result;
        }

        // here we can support palindromes
        // retrieve the middle char
        String midChar = "";
        for (int i=0; i < 256; i++) {
            if (charCount[i] % 2 == 1) {
                midChar += (char) i;
                charCount[i]--;
                break;
            }
        }

        System.out.println("midChar: " + midChar);

        int length = 0;
        for (int i = 0; i < 256; i++) {
            // this character exists
            if (charCount[i] > 0) {
                // we only need to create one side of the palindrome
                // charCount[i] /= 2;

                // this is the length of the one side of the palindrome
                length += charCount[i];
            }
        }

        System.out.println("original length: " + length);

        // use the DFS helper method to generate the half palindromes
        generatePalindromesHelper(s, result, midChar, charCount, length, midChar);
        return result;
    }


    private void generatePalindromesHelper(String s, List<String> result, String current,
                                           int[] charCount, int halfLength, String mid) {

        System.out.println("length: " + halfLength);
        System.out.println("current: " + current);
        // completed building our palindrome
        if (halfLength == 0) {
            // create the other half of the palindrome
            // StringBuilder reverse = new StringBuilder(current).reverse();

            // create the final result
            // left side + mid chars + reversed right side
            // result.add(current + mid + reverse);
            System.out.println("adding: " + current);
            result.add(current);
        }

        // loop through all possible chars
        // use backtracking
        for (int i=0; i < 256; i++) {
            // check if this char exists in the string
            if (charCount[i] <= 0) {
                continue;
            }

            // pick the existing char
            char c = (char) i;

            // decrement our count after the pick
            charCount[i]-=2;

            // recursive call with our pick
            generatePalindromesHelper(s, result, c + current + c, charCount, halfLength-2, mid);

            // increment the count when done
            charCount[i]+=2;
        }

    }


}
