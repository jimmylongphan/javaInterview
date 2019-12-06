package com.javainterview.app.ArrayInterview;

/**
 * Created on 12/6/2019.
 */
public class DuplicateZeroes {
    public void duplicateZeros(int[] arr) {
        // iterate from right to left
        // if we see a zero
        // shift all from current position
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            if (arr[i] == 0) {
                shiftAllRight(arr, i);
                // the zero is shifted to the right
                // but we want to keep the current 0, decrement index
            }
        }
    }


    public void shiftAllRight(int[] arr, int leftIndex) {
        // start from the right and stop at leftIndex
        for (int i=arr.length - 1; i > leftIndex; i--) {
            arr[i] = arr[i-1];
        }
    }
}
