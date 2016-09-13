package com.javainterview.app.BackTrackingInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 9/13/2016.
 */
public class WordSearchTest {

    @Test
    public void testExist() throws Exception {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        WordSearch ws = new WordSearch();
        boolean exists = ws.exist(board, word);
        assertTrue(exists);
    }
}