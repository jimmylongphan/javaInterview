package com.javainterview.app.ArrayInterview;

import java.util.Arrays;
import java.util.Random;

/**
 * Google foobar
 * shuffle all elements in an array
 */
public class ArrayShuffle {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void shuffle(int[] array) {

        int length = array.length;
        // shuffle the input in place
        for (int i = 0; i < length; i++) {
            int swap_index = getRandom(0, length - 1);
            swap(array, i, swap_index);
        }

    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }

}
/**
 *
# Python
import random

def get_random(floor, ceiling):
    return random.randrange(floor, ceiling + 1)


def shuffle(the_list):
    length = len(the_list)
    
    for index, value in enumerate(the_list):
        swap_index = get_random(0, length - 1)
        the_list[index], the_list[swap_index] = the_list[swap_index], the_list[index]
**/