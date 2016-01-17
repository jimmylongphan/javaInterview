package com.javainterview.app.GameInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 1/13/2015.
 */
public class NimGameTest {


    @Test
    public void testFour() throws Exception {
        NimGame game = new NimGame();
        
        int stoneCount = 4;
        assertFalse( game.canIWin(stoneCount) );
    }
    
    
    @Test
    public void testFive() {
        NimGame game = new NimGame();
        
        int stoneCount = 5;
        assertTrue( game.canIWin(stoneCount) );
    }

    
}

