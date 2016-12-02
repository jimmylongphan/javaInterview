package com.javainterview.app.countInterview;


/**
 * Created on 10/2/2015.
 * Fibonacci is a sequence of numbers where
 * the next number is the sum of the previous two fibonacci.
 *
 * The first two numbers are 0 and 1.
 */
public class Fibonacci {

    public static int[] fibonacciSave = new int[200];

    /**
     * Using recursion
     *
     * Runtime: O(2^n)
     * It is exponential because there are two calls for every num
     *
     * @param num number to find fibonacci
     * @return fibonacci number
     */
    public int fibonacciRecursive(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        int fibonacci = fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);

        return fibonacci;
    }


    /**
     * Iterate to find fibonacci
     *
     * Runtime: O(n)
     *
     * @param num val to calculate
     * @return final val
     */
    public int fibonacciIterative(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        int fibo1 = 1;
        int fibo2 = 2;
        int fibonacci = 1;

        for (int i = 3; i < num; i++) {
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;

            System.out.print(fibonacci + " ");
        }

        return fibonacci;
    }


    /**
     * Check if we already calculated fibonacci and return its val
     *
     * @param num fabionacci to find
     * @return calculated val
     */
    public int fibonacciPrecompute(int num) {
        // base case for recursion
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        // check if we already precomputed the fibonacci val
        if (fibonacciSave[num] != 0) {
            return fibonacciSave[num];
        }

        // calculate and store the fibonacci val
        fibonacciSave[num] = fibonacciPrecompute(num - 1) + fibonacciPrecompute(num - 2);
        return fibonacciSave[num];
    }


}
