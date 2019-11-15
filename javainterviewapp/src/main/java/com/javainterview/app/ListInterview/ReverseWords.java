package com.javainterview.app.ListInterview;

import java.util.List;

/**
 * Created on 11/14/2019.
 */
public class ReverseWords {

    public static void reverse_words(List<Character> message) {
        reverseList(message);
        reverseEachWord(message);
    }

    public static void reverseList(List<Character> message) {
        int size = message.size();
        int middle = size / 2;
        for (int i=0; i < middle; i++) {
            int rightIndex = size - i - 1;
            // store leftmost char
            char temp = message.get(i);
            // set left char
            message.set(i, message.get(rightIndex ));

            // set right char
            message.set(rightIndex, temp);
        }
    }

    public static void reverseEachWord(List<Character> message) {
        // find the indices of the start char and end char of each word
        for (int startIndex=0; startIndex < message.size();) {
            while (message.get(startIndex) == ' ') {
                startIndex++;
            }

            // endIndex will be at the space or end of array
            int endIndex = startIndex + 1;
            while (endIndex < message.size() && message.get(endIndex) != ' ') {
                endIndex++;
            }

            reverseList(message.subList(startIndex, endIndex));  // exclusive
            startIndex = endIndex;
        }
        // reuse the reverseList with a subList of those indices
    }

}
