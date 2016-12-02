package com.javainterview.app.BackTrackingInterview;


/**
 * LeetCode 79
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * 
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 *
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false
 */
 public class WordSearch {

    /**
     * Method to call to check if word exists in the board
     *
     * @param board board to check
     * @param word  word to find
     * @return true if found
     */
    public boolean exist(char[][] board, String word) {
        // loop through all rows
        for (int r = 0; r < board.length; r++) {
            // loop through all cols
            for (int c = 0; c < board[0].length; c++) {
                // check if this word exists at this row, col
                if (exist(board, r, c, word, 0)) {
                    return true;
                }
            }
        }

        // went through all combinations, not found
        return false;
    }

    /**
     * Helper method to check if the word exists give the starting row and col
     *
     * @param board     board to check
     * @param r         the current row
     * @param c         the current col
     * @param word      the word to find
     * @param wordIndex current position in the word
     * @return true if found
     */
    private boolean exist(char[][] board, int r, int c, String word, int wordIndex) {
        // reached the end of the word
        // the word is found
        if (wordIndex == word.length()) {
            return true;
        }

        // boundary check
        if (r > board.length - 1 || r < 0 ||
                c < 0 || c > board[0].length - 1) {
            return false;
        }

        // the position in this board does not match the current word index
        if (board[r][c] != word.charAt(wordIndex)) {
            return false;
        }

        // visited the current position in the board
        // this will prevent cycles when visiting next positions
        board[r][c] = '*';

        // now that we have found the current char
        // search for the next char using its position
        int nextIndex = wordIndex + 1;

        // see if any of the adjacent positions contain the next char
        boolean result = exist(board, r - 1, c, word, nextIndex) || // previous row
                exist(board, r, c - 1, word, nextIndex) || // previous col
                exist(board, r, c + 1, word, nextIndex) || // next col
                exist(board, r + 1, c, word, nextIndex); // next row

        // reset the val at the current board position
        // to allow backtracking
        board[r][c] = word.charAt(wordIndex);

        // returns true if any of the adjacent positions contains the next char
        return result;
    }

}
