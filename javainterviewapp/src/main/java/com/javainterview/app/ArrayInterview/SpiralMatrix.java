package com.javainterview.app.ArrayInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 5/8/2016.
 *
 * LeetCode 54
 * Microsoft, Google, Uber
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *  For example, Given the following matrix:
 *
 *
 * [
 * [ 1, 2, 3 ]
 * [ 4, 5, 6 ]
 * [ 7, 8, 9 ]
 * ]
 *
 * You should return [1,2,3,6,9,8,7,4,5]
 *
 * Runtime O(m * n) we are looping through all elements
 *
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        // null check
        if (matrix.length == 0) {
            return result;
        }

        // set the boundaries
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        // loop while our indices are less than the limit
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse to top right
            for (int c = colBegin; c <= colEnd; c++) {
                result.add(matrix[rowBegin][c]);
            }
            // increment to next begin row
            rowBegin++;

            // traverse down from the right side to bottom right
            for (int r = rowBegin; r <= rowEnd; r++) {
                result.add(matrix[r][colEnd]);
            }
            // decrement to previous end column
            colEnd--;

            // traverse left to bottom left
            // if check is because we are incrementing rowBegin before rowEnd
            // this shows that we already processed the rowEnd
            if (rowBegin <= rowEnd) {
                for (int c = colEnd; c >= colBegin; c--) {
                    result.add(matrix[rowEnd][c]);
                }
            }
            // decrement to previous end row
            rowEnd--;

            // traverse up to top left
            // if check because we are decrementing rowEnd before rowBegin
            // this shows that we already processed the colEnd
            if (colBegin <= colEnd) {
                for (int r = rowEnd; r >= rowBegin; r--) {
                    result.add(matrix[r][colBegin]);
                }
            }
            // increment to next begin column
            colBegin++;
        }

        return result;
    }
}
