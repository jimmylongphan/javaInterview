package com.javainterview.app.countInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10/2/2015.
 * "Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print “Fizz” instead of the number and
 * for the multiples of five print “Buzz”.
 * For numbers which are multiples of both three and five print “FizzBuzz”."
 */
public class FizzBuzz {

    public int fizzBuzz(int num, String key) {
        // keep a count of fizzes and buzzes
        Map<String, Integer> counter = new HashMap<String, Integer>();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            if (i % 15 == 0) {
                result.append("FizzBuzz");
            } else if (i % 5 == 0) {
                result.append("Buzz");
            } else if (i % 3 == 0) {
                result.append("Fizz");
            } else {
                result.append(i);
            }
            System.out.print(result.toString() + ' ');

            if (counter.containsKey(result.toString())) {
                counter.put(result.toString(), counter.get(result.toString()));
            } else {
                counter.put(result.toString(), 1);
            }

            // reset the string builder
            result.setLength(0);
        }

        return counter.get(key);
    }
}
