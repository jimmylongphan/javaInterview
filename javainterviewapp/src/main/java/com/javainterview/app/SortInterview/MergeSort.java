package com.javainterview.app.SortInterview;

/**
 * Created on 2/22/2016.
 */
public class MergeSort {

    /**
     * We are merge sorting the array between the two indices
     * First we sort the two sides
     * Then merge the sorted sides.
     *
     * @param low start index
     * @param high end index
     */
    public void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // calculate the middle point between low and high
        // high-low /2 is the distance
        // then we add that distance to low
        int middle = low + (high-low)/2;

        // merge the left side of the array
        mergeSort(array, low, middle);

        // merge the right side of the array
        mergeSort(array, middle + 1, high);

        // merge both sides together
        merge(array, low, middle, high);
    }

    private void merge(int[] array, int low, int middle, int high) {
        // index of temp array
        int tempIndex = 0;

        // left index
        int left = low;

        // right index
        int right = middle + 1;

        // create a temporary array to store values
        int[] tempArray= new int[high-low+1];

        // merge the two arrays
        while (left <= middle && right <= high) {
            // if the value of th left is less, then place into temp
            if (array[left] < array[right]) {
                tempArray[tempIndex++] = array[left++];
            } else {
                // put the value from the right array into temp
                tempArray[tempIndex++] = array[right++];
            }
        }

        // merge the remaining left elements into temp
        while (left <= middle) {
            tempArray[tempIndex++] = array[left++];
        }

        // merge the remaining right elements into temp
        while (right <= high) {
            tempArray[tempIndex++] = array[right++];
        }

        // move from temp array to target array
        for (int i=low; i <= high; i++) {
            // offset of the tempArray is low
            // array goes from indices low to high
            // tempArray goes from 0 to high-low (distance)
            array[i] = tempArray[i-low];
        }

    }

}
