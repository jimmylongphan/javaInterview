package com.javainterview.app.DynamicInterview;

/**
 * LeetCode 221 Maximal Square
 *
 * Company: Apple, Airbnb, Facebook
 *
 * Tags: Dynamic Programming
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 4.
 *
 * Created on 10/8/2016.
 *
 * dp[i][j] represent the edge length of the largest square ENDING at position (i, j)
 *
 * Top, Left, and Top Left decides the size of the square.
 * If all of them are same, then the size of square increases by 1.
 * If they're not same, they can increase by 1 to the minimal square.
 *
 * We are calculating the longest side of a square possible.
 */
public class MaximalSquare {

    /**
     * Get the area of the largest square of 1s
     * dp[i][j] represent the edge length of the largest square ENDING at position (i, j)
     *
     * @param matrix input matrix
     * @return area of square
     */
    public int maximalSquare(char[][] matrix) {
        // error case
        if (matrix.length == 0) {
            return 0;
        }

        // initialize boundaries
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;
        int result = 0;

        // setup the memoization
        // everything starts at zero
        int[][] dp = new int[maxRows + 1][maxCols + 1];

        // go through all the rows
        for (int row = 1; row <= maxRows; row++) {
            // go through all the columns
            for (int col = 1; col <= maxCols; col++) {
                // if the top left is a 1
                if (matrix[row - 1][col - 1] == '1') {
                    // get the min of result of left and top left
                    int maxPrevious = Math.min(dp[row][col - 1], dp[row - 1][col - 1]);
                    // compare the minimum of top and max previous
                    maxPrevious = Math.min(maxPrevious, dp[row - 1][col]);

                    // if any of the corner indexes have a one, then they will have a val
                    // set the result to the dp and add 1
                    dp[row][col] = maxPrevious + 1;

                    // keep the result of the larger current or result
                    result = Math.max(dp[row][col], result);
                }
            }
        }

        // return the area of the square
        return result * result;
    }

}
