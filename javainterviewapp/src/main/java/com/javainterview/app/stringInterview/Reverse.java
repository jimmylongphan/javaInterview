package com.javainterview.app.stringInterview;



public class Reverse {

    /**
     * LeetCode 151
     * Company: Microsoft, snapchat, apple, bloomberg, yelp
     * Tags: String
     *
     * Remove extra whitespace
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }


    /**
     * Reverse a string by reversing the order of the words
     *
     * Runtime: O(n)
     *
     * @param s string to reverse
     * @return reversed string
     */
    public String reverseOrderOfWords(String s) {
        StringBuilder result = new StringBuilder();
        int endWordPos = s.length();

        // go through the string from end to beginning by char
        for (int i = s.length() - 1; i >= 0; i--) {
            // check if we are at the delimiter or the beginning
            if (s.charAt(i) == ' ' | i == 0) {
                if (i != 0) {
                    // not at beginning so we can add the delimiter
                    // do not include the first delimiter
                    result.append(s.substring(i + 1, endWordPos));

                    // add the delimiter to result
                    result.append(" ");
                } else {
                    // we are at beginning so add the rest of the string
                    // we don't kneed delimiter because this is the last word
                    result.append(s.substring(i, endWordPos));
                }

                // move the word position to i which is where the word begins
                endWordPos = i;
            }
        }

        // return the result which has the sentence words reversed
        return result.toString();
    }


    /**
     * LeetCode 186
     *
     * Company: Amazon, Microsoft, Uber
     * Tags: String
     *
     * Reverse the letters of the words in a string.
     * The ordering of the words remain the same.
     * For every word, the letters are reversed.
     *
     * Runtime: O(n)
     *
     * @param s string to reverse
     * @return reversed string
     */
    public String reverseWordsInString(String s) {
        StringBuilder result = new StringBuilder();
        int startWordPos = 0;

        // go through the string from end to beginning by char
        for (int i = 0; i < s.length(); i++) {
            // check if we are at the delimiter or the beginning
            if (s.charAt(i) == ' ' | i == s.length() - 1) {
                if (i != s.length() - 1) {
                    // not at beginning so we can add the delimiter
                    // do not include the first delimiter
                    String reverseWord = s.substring(startWordPos, i);
                    reverseWord = reverseStringBuilder(reverseWord);
                    result.append(reverseWord);

                    // add the delimiter to result
                    result.append(" ");
                } else {
                    // we are at beginning so add the rest of the string
                    // substring is exclusive
                    String reverseWord = s.substring(startWordPos, i + 1);
                    reverseWord = reverseStringBuilder(reverseWord);
                    result.append(reverseWord);
                }

                // move the word position to i which is where the word begins
                startWordPos = i + 1;
            }
        }

        // return the result which has the sentence words reversed
        return result.toString();
    }


    /**
     * LeetCode: 344
     * Reverse the string using stringbuilder
     *
     * Tags: Two Pointers, String
     *
     * Runtime: O(n)
     *
     * @param s string to reverse
     * @return value of reversed string
     */
    public String reverseStringBuilder(String s) {
        // Strings are immutable in java so we need to use StringBuilder
        StringBuilder result = new StringBuilder(s);

        int endPos = s.length() - 1;
        // loop through all the chars in the string
        for (int i = 0; i < s.length() / 2; i++) {
            // replace the left and right side characters
            // in the stringbuilder value
            result.setCharAt(i, s.charAt(endPos - i));
            result.setCharAt(endPos - i, s.charAt(i));
        }

        return result.toString();
    }

    /**
     * Method to reverse a string using char array
     *
     * Runtime: O(n)
     *
     * @param s string to reverse
     * @return reversed string
     */
    public String reverseStringArray(String s) {
        char[] a = s.toCharArray();

        int endPos = a.length - 1;
        char temp;

        // loop through half of the string
        for (int i = 0; i < s.length() / 2; i++) {
            temp = a[i];
            // replace the first part with the second part
            a[i] = a[endPos];

            // replace the second part with the first part
            a[endPos] = temp;

            // move the index backwards
            endPos--;
        }

        return new String(a);
    }


    /**
     * LeetCode 186
     *
     * Company: Amazon, Microsoft, Uber
     * Tags: String
     *
     * Start by reversing the entire array
     * Then we reverse the words delimited by whitespace
     *
     * @param s the char array to reverse
     */
    public void reverseWords(char[] s) {
        // reverse the entire array
        reverse(s, 0, s.length - 1);

        // with the reversed array
        // just reverse individual words
        for (int start=0, end=0; end <= s.length; end++) {
            if (end==s.length || s[end] == ' ') {
                reverse(s, start, end-1);
                start = end+1;
            }
        }
    }


    /**
     * Reverse everything in the char array from beginning to end
     *
     * @param s array to reverse
     * @param start beginning position
     * @param end end position
     */
    public void reverse(char[] s, int start, int end) {
        char temp;
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


}