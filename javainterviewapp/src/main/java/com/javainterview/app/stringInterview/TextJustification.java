package com.javainterview.app.stringInterview;


import java.util.ArrayList;
import java.util.List;

/**
 * TODO test
 *
 * LeetCode: 8
 * 
 * Company: LinkedIn, Airbnb
 * Tags: String
 * 
 * Given an array of words an a length, L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * Pack as many words as you can in each line. Pad exta spaces ' ' when
 * necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots 
 * on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is 
 * inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * Corner Cases:
 * A line other than the last line might contain only one word.
 * What should you do in this case?
 * In this case, that line should be left-justified.
 * 
 */
public class TextJustification {

    /**
     *
     * @param words list of words to format
     * @param maxWidth maximum width of each line
     * @return the words for each line
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for (int startWordIndex = 0, endWordIndex; startWordIndex < words.length; ) {
            // width of words without space
            int width = 0;
            for (endWordIndex = startWordIndex; endWordIndex < words.length &&
                    width + words[endWordIndex].length() + (endWordIndex - startWordIndex) <= maxWidth; endWordIndex++) {
                width += words[endWordIndex].length();
            }

            // for last line, space=1
            int space = 1, extra = 0;
            // not 1 word (div-by-zero) and not last line
            if (endWordIndex - startWordIndex != 1 && endWordIndex != words.length) {
                // minus 1 to exclude skip last word
                space = (maxWidth - width) / (endWordIndex - startWordIndex - 1);
                extra = (maxWidth - width) % (endWordIndex - startWordIndex - 1);
            }

            StringBuilder line = new StringBuilder(words[startWordIndex]);

            for (startWordIndex = startWordIndex + 1; startWordIndex < endWordIndex; startWordIndex++) {
                for (int s = space; s > 0; s--) {
                    line.append(" ");
                }
                if (extra-- > 0) {
                    line.append(" ");
                }
                line.append(words[startWordIndex]);
            }

            for (int s = maxWidth - line.length(); s > 0; s--) {
                line.append(" ");
            }
            result.add(line.toString());
        }
        return result;
    }

}

