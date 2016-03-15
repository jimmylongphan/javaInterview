package com.javainterview.app.countInterview;

import java.util.*;

/**
 * Given an array of integers, every element appears twice except one.
 * Find the integer.
 * 
 * Solution: O(n)
 * 
 * XOR is commutative, so changing the order does not have an effect.
 * 
 * N XOR N = 0
 * A XOR 0 = A
 * 
 * If we XOR all the numbers together, eventually we will be left with the 
 * excluded number.
 */

public class SingleNumber {
     
     int singleNmber(int numbers[]) {
         int result = 0;
         for (int i=0; i < numbers.length; i++) {
             result ^= numbers[i];
         }
         return result;
     }
     
}

