package com.javainterview.app.GameInterview;

/**
 * The definition of the nim game is where 2 players take turns removing
 * stones from a heap.
 * 
 * You are the player to take the first turn.
 * 
 * Each player can remove 1,2, or 3 stones.
 * 
 * The player to remove the last remaining stones wins.
 * 
 * Hint:  If there are 4 stones, you will always lose
 * If there are 5 stones, you can take 1, opponent 3, you 1.
 * Then you will win.
 * 
 */ 
public class NimGame {
    
    /**
     * Determine if you can win given the number of stones.
     * Given the hint, it looks like whenever there are 4 stones left
     * and it is your turn, then you will lose.
     * 
     * @param numStones the number of stones during your turn.
     */
    public boolean canIWin( int numStones ) {
        if (numStones % 4 == 0 ) {
            return false;
        }
        return true;
    }
    
}

