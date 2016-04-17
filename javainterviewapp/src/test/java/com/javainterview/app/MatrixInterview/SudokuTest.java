package com.javainterview.app.MatrixInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/3/2015.
 */
public class SudokuTest {

    @Test
    public void testIsSudoku() throws Exception {
        int[][] goodSudoku = {
                {4,3,5,2,6,9,7,8,1},
                {6,8,2,5,7,1,4,9,3},
                {1,9,7,8,3,4,5,6,2},
                {8,2,6,1,9,5,3,4,7},
                {3,7,4,6,8,2,9,1,5},
                {9,5,1,7,4,3,6,2,8},
                {5,1,9,3,2,6,8,7,4},
                {2,4,8,9,5,7,1,3,6},
                {7,6,3,4,1,8,2,5,9}
        };

        Sudoku sudoku = new Sudoku();
        boolean good = sudoku.isSudoku(goodSudoku);
        assertTrue(good);
    }

    @Test
    public void testIsSudoku2() throws Exception {
        int[][] goodSudoku = {
                {4,3,5,2,6,9,7,8,1},
                {6,8,2,5,7,1,4,9,3},
                {1,9,7,8,3,4,5,6,2},
                {8,2,6,1,9,5,3,4,7},
                {3,7,4,6,8,2,9,1,5},
                {9,5,1,7,4,3,6,2,8},
                {5,1,9,3,2,6,8,7,4},
                {2,4,8,9,5,7,1,3,6},
                {7,6,3,4,1,8,9,9,9}
        };

        Sudoku sudoku = new Sudoku();
        boolean bad = sudoku.isSudoku(goodSudoku);
        assertFalse(bad);
    }
}