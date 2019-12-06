package com.javainterview.app.countInterview;

/**
 * Created on 2/17/2016.
 */
public class BigIntegerAdd {

    /**
     * Method to add two integers as BigIntegerAdd
     * @param int1 first val
     * @param int2 second val
     * @return their sum represented as a string
     */
    public String add(int int1, int int2) {
        // determine max array length
        int length1 = getLength(int1);
        int length2 = getLength(int2);
        int arrayLength = Math.max(length1, length2);

        // convert the digits into an array
        // in reversed order 123 -> [3, 2, 1, 0, 0]
        int array1[] = intToArray(int1, length1, arrayLength);
        int array2[] = intToArray(int2, length2, arrayLength);

        // sum the arrays
        return sumArray(array1, array2);
    }

    /**
     * Loop through both integer arrays and add their digits.
     * The arrays store the digits in reverse order.
     *
     * @param array1 first
     * @param array2 second
     * @return String representation of their sum
     */
    private String sumArray(int[] array1, int[] array2) {
        int carry = 0;
        int sumArray[] = new int[array1.length + 1];

        // loop through the arrays and sum their values
        for (int i=0; i < array1.length; i++) {
            // sum digits and carry
            // mod by 10
            sumArray[i] = (array1[i] + array2[i] + carry) % 10;

            // calculate the carry using division
            carry = (array1[i] + array2[i] + carry) / 10;
        }

        // if there is a last carry, then add that to the end
        sumArray[array1.length] = carry;

        // convert the array to a string
        return arrayToString(sumArray);
    }

    /**
     * Get the length of an integer by converting it to string
     * @param val
     * @return length of the val
     */
    private int getLength(int val) {
        return Integer.toString(val).length();
    }

    /**
     * Convert this integer into an array. Reversing the digits
     * @param val val to convert
     * @param valLength length of this integer
     * @param arrayLength Maximum length of the sum
     * @return integer array of the conversion
     */
    private int[] intToArray(int val, int valLength, int arrayLength) {
        int result[] = new int[arrayLength];

        for (int i=0; i < arrayLength; i++) {
            if (i<valLength) {
                // get the digit from val right to left
                result[i] = getDigitAtIndex(val, valLength - i - 1);
            } else {
                // fill rest of array with 0
                result[i] = 0;
            }
        }

        return result;
    }

    /**
     * Get the digit at an index
     * @param val val of number
     * @param index position to get
     * @return int val of the digit
     */
    private int getDigitAtIndex(int val, int index) {
        String intStr = Integer.toString(val);
        String subString = intStr.substring(index, index + 1);
        return Integer.parseInt(subString);
    }

    /**
     * Convert an integer array to string
     * @param sumArray the array to convert
     * @return string representation of the integer array
     */
    private String arrayToString(int[] sumArray) {
        String sum = "";

        // loop from end to beginning
        // This is because the digits are stored in reversed order for easier additions
        for (int i=sumArray.length-1; i>=0; i--) {

            // ignore if first digits are 0
            if (sumArray[i]==0) {
                continue;
            }

            // Concatenate the digit into the final string
            sum += sumArray[i];

            // add commas into the result
            if ((i%3 == 0) && i!=0) {
                sum += ",";
            }
        }

        return sum;
    }
}
