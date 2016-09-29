package com.javainterview.app.stringInterview;


/**
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
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<String>();
        
        // iterate through all the words
        // i will be the starting index
        for (int i=0; w; i < words.length; i = w) {
            // reset current total length
            int len = -1;
            // initialize wordIndex to starting index
            // loop while word index is within the array
            // and the current length is less than the max width
            // NOTE: +1 is for the whitespace before the new word
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
                // add the current words length to the total length
                len += words[w].length() + 1;
            }
            
            // we now have as much words as possible that can fit within maxWidth
            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            // not 1 word, not last line
            if (w != i && w != words.length) {
                // subtract current total length from max width
                // (w - i - 1) is the number of whitespace between words
                // example:  foo bar ken
                // 2 - 0 - 1 = 2  => 2 whitespaces
                // 
                space = (maxWidth - len) / (w - i - 1) + 1;
                
                
                extra = (maxWidth - len) % (w - i - 1);
            }
            
            
            
        }
    }
    
}

