package com.javainterview.app.stringInterview;

/**
 * Created on 10/3/2015.
 */
public class NumberToWord {

    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    /**
     * This method is only called if the number is <= 1000
     *
     * @param num value with 3 digits
     * @return
     */
    private String convertLessThanThousand(int num) {

        String current;

        // get the words for the 2 right most digits

        // use the teen naming convetion
        if (num % 100 < 20) {
            current = numNames[num % 100];
            num /= 100;
        } else {
            // use the naming convetion for numbers above 20

            // this is the right digit of a 2 digit number
            current = numNames[num % 10];
            num /= 10;

            // this is the left digit of a 2 digit number
            // for the -ties numbers
            current = tensNames[num % 10] + current;
            num /= 10;
        }

        // finished conversion
        if (num == 0) {
            return current;
        }

        // still values in the hundred position
        String result = numNames[num] + " hundred" + current;
        return result;
    }

    /**
     * Convert a given integer to words
     * Handles large and negative numbers
     *
     * @param num value to convert
     * @return string after conversion
     */
    public String convert(int num) {
        if (num == 0) {
            return "zero";
        }
        String prefix = "";

        // convert to positive for easier conversion
        if (num < 0) {
            num = -num;
            prefix = "negative ";
        }

        String current = "";
        int specialNamePlace = 0;

        do {
            int n = num % 1000;
            if (n != 0) {
                // convert the rightmost 3 digits
                String s = convertLessThanThousand(n);

                // current string goes into rightmost position
                // insert the special names in front
                // start with thousands, then increment the special holder
                current = s + specialNames[specialNamePlace] + current;
            }
            specialNamePlace++;
            num /= 1000;
        } while (num > 0);

        String result = prefix + current;
        result = result.trim();
        return result;
    }


}
