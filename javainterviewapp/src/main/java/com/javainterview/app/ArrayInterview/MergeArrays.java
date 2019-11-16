package com.javainterview.app.ArrayInterview;

/**
 * Created on 11/16/2019.
 */
public class MergeArrays {
    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {
        // combine the sorted arrays into one large sorted array
        int[] result = new int[myArray.length + alicesArray.length];

        int myArrayIndex = 0;
        int alicesArrayIndex = 0;
        int resultIndex = 0;

        while (myArrayIndex < myArray.length && alicesArrayIndex < alicesArray.length) {
            if ( myArray[myArrayIndex] <= alicesArray[alicesArrayIndex] ) {
                result[resultIndex++] = myArray[myArrayIndex];
                myArrayIndex++;
            } else {
                result[resultIndex++] = alicesArray[alicesArrayIndex];
                alicesArrayIndex++;
            }
        }

        // handle the remaining arrays
        while (myArrayIndex < myArray.length) {
            result[resultIndex++] = myArray[myArrayIndex];
            myArrayIndex++;
        }

        while (alicesArrayIndex < alicesArray.length) {
            result[resultIndex++] = alicesArray[alicesArrayIndex];
            alicesArrayIndex++;
        }

        return result;
    }
}
