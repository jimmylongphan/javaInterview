package com.javainterview.app.MatrixInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 36
 * Company: Snapchat, Uber, Apple
 * Tags: Hash Table
 * 
 * Created on 10/3/2015.
 * Validate sudoku
 *
 * Rules of sudoku
 * All rows have 1-9
 * All columns have 1-9
 * For each 3x3 square, the values are 1-9
 */
public class Sudoku {


    /**
     * First check all rows
     * Check all cols
     *
     * Check all subsquares
     *
     * @param board
     * @return
     */
    public boolean isSudoku(int[][] board) {
        // check all the rows and columns for uniqueness
        for (int i = 0; i < 9; i++) {
            // rows are looped
            // cols position is 0-8
            boolean validRows = checkSubBoard(board, i, 0, i, 8);
            if (!validRows) {
                return false;
            }

            // rows position is 0-8
            // cols is looped
            boolean validCols = checkSubBoard(board, 0, i, 8, i);
            if (!validCols) {
                return false;
            }
        }

        // check all 3x3 boards
        // i is the multiple of 3
        for (int i = 0; i < 3; i++) {
            // j is the multiple of 3
            for (int j = 0; j < 3; j++) {
                int xStart = 3 * i;
                int xEnd = xStart + 2;
                int yStart = 3 * j;
                int yEnd = yStart + 2;

                boolean validBoard = checkSubBoard(board, xStart, yStart, xEnd, yEnd);
                if (!validBoard) {
                    return false;
                }
            }
        }

        // all values have been checked
        return true;
    }

    /**
     * Method to check if all values are unique in this board given the dimensions.
     *
     * @param board  original board
     * @param xStart first position of row
     * @param yStart first position of column
     * @param xEnd   second position of row
     * @param yEnd   second position of column
     * @return true if all values unique
     */
    private boolean checkSubBoard(int[][] board, int xStart, int yStart, int xEnd, int yEnd) {
        // keep track of all numbers in this table
        Set<Integer> set = new HashSet<Integer>();

        // we are checking the positions in this board given the positions
        // to be valid, all positions must have a unique number
        for (int r = xStart; r <= xEnd; r++) {
            for (int c = yStart; c <= yEnd; c++) {
                int val = board[r][c];
                if (!set.contains(val)) {
                    set.add(val);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
