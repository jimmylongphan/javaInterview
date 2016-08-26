package com.javainterview.app.GameInterview;

/**
 * Leetcode 348
 * Medium
 *
 * Company: Microsoft, Google
 * Tag: Design
 *
 * Design a tic-tac-toe game that is played between two players
 * n x n grid
 *
 * Rules
 * 1. A move is guaranteed to be valid and is placed on an empty block.
 * 2. Once a winning condition is reached, no more moves allowed
 * 3. A player who succeeds in place n of their marks in a horizontal,
 * vertical, or diagonal row wins.
 *
 *
 * Solution:
 * Keep arrays for every row and column.
 * When a player adds to a row and column, we add that value to that row.
 * Example:  Player 1 chooses row 2, then row[1] += 1
 * If the value of row[1] reaches the size of the table, they win.
 * If row[1] == 3, then we know player 1 put 3 x or o in row 2.
 *
 * O(1) runtime
 */

public class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd;
        // set the value to add to the board based on player
        if (player == 1) {
            toAdd = 1;
        } else {
            toAdd = -1;
        }

        rows[row] += toAdd;
        cols[row] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }

        // keep track of diagonal
        // col 2, row 0
        // col 1, row 1
        // col 0, row 2
        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }

        int size = rows.length;

        // check win conditions
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antiDiagonal) == size) {
            return player;
        }

        // no one wins
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */