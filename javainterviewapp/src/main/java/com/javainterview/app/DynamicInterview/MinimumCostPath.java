package com.javainterview.app.DynamicInterview;

/**
 * Created on 11/5/2016.
 *
 * Saw this posted on 3acres for AirBnb
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 *
 * Runtime: O(rowSize * colSize)
 *
 */
public class MinimumCostPath {

    /**
     * Function that returns the minimum of 3 integers.
     *
     * @param x first num
     * @param y second num
     * @param z third num
     * @return the smallest of three integers
     */
    public static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        }
        return (y < z) ? y : z;
    }

    public static int minCost(int cost[][], int rowSize, int colSize) {
        int r, c;
        int totalCost[][] = new int[rowSize + 1][colSize + 1];

        totalCost[0][0] = cost[0][0];

        // initialize first column of total cost array
        for (r = 1; r <= rowSize; r++) {
            totalCost[r][0] = totalCost[r - 1][0] + cost[r][0];
        }

        // initialize first row of total cost array
        for (c = 1; c <= colSize; c++) {
            totalCost[0][c] = totalCost[0][c - 1] + cost[0][c];
        }

        // construct the rest of the totalCost array
        for (r = 1; r <= rowSize; r++) {
            for (c = 1; c <= colSize; c++) {
                // the current total cost is the minimum of 3 subproblems
                // top left, top, left
                totalCost[r][c] = cost[r][c] +
                        min(totalCost[r - 1][c - 1], totalCost[r - 1][c], totalCost[r][c - 1]);
            }
        }

        return totalCost[rowSize][colSize];
    }

}
