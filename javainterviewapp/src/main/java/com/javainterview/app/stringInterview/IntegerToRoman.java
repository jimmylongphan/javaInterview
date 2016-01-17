package com.javainterview.app.stringInterview;

/**
 * Created on 1/16/2016.
 * Given an integer, convert it to roman numerals.
 *
 * Range 1 - 3999
 *
 * Solution:
 * We are converting each digit in the number.
 * Convert the thousands by dividing by 1000 and then use the index in the array.
 * Convert the hundreds by mod by 1000, then divide by hundred
 * Convert the tens by mod by 100, then divide by 10
 * Convert the ones by mod by 10.
 */
public class IntegerToRoman {

    String thousands[] = {"", "M", "MM", "MMM"};
    String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String convert(int num) {
        String result = thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
        return result;
    }
}
