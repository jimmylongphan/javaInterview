package com.javainterview.app.stringInterview;

import java.util.*;

public class ReverseSentence {
    
    public String reverseSentenceByWords(String s) {
        StringBuilder result = new StringBuilder();
        int endWordPos = s.length();
        
        // go through the string from end to beginning by char
        for( int i=s.length-1; i >= 0; i--) {
            // check if we are at the delimiter or the beginning
            if (s.charAt(i) == ' ' | i == 0 ) {
                if( i != 0 ) {
                    // not at beginning so we can add the delimiter
                    // do not include the first delimiter
                    result.append( s.subString(i+1, endWordPos ));
                    
                    // add the delimiter to result
                    result.append(" ");
                } else {
                    // we are at beginning so add the rest of the string
                    result.append( s.subString(i, endWordPos) );
                }
                
                // move the word position to i which is where the word begins
                endWordPos = i;
            }
        }
        
        // return the result which has the sentence words reversed
        return result.string();
    }
    
    
    public String reverseWordsInString( String s ) {
        StringBuilder result = new StringBuilder();
        int startWordPos = 0;
        
        // go through the string from end to beginning by char
        for( int i=0; i < s.length; i++) {
            // check if we are at the delimiter or the beginning
            if (s.charAt(i) == ' ' | i == s.length-1 ) {
                if( i != s.length-1 ) {
                    // not at beginning so we can add the delimiter
                    // do not include the first delimiter
                    String reverseWord = s.subString(startWordPos, i);
                    result.append( reverseWord );
                    
                    // add the delimiter to result
                    result.append(" ");
                } else {
                    // we are at beginning so add the rest of the string
                    // substring is exclusive
                    String reverseWord = s.subString(startWordPos, i+1 );
                    result.append( reverseWord );
                }
                
                // move the word position to i which is where the word begins
                startWordPos = i+1;
            }
        }
        
        // return the result which has the sentence words reversed
        return result.string();
    }
    
    
    public String reverseStringBuilder( String s ) {
        // Strings are immutable in java so we need to use StringBuilder
        StringBuilder result = new StringBuilder(s);
        
        int endPos = s.length() - 1;
        // loop through all the chars in the string
        for( int i=0; i < s.length() / 2; i++) {
            // replace the left and right side characters
            // in the stringbuilder value
            result.setCharAt(i, s.charAt(endPos-i));
            result.setCharAt(endPos-i, s.charAt(i));
        }
        
        return result.str();
    }
    
    public String reverseStringArray( String s ) {
        char[] a = s.toCharArray();
        
        int endPos = a.length-1;
        char temp;
        char first;
        char second;
        for( int i=0; i < s.length() / 2; i++) {
            temp = a[i];
            a[i] = a[endPos-i];
            a[endPos] = temp;
            endPos--;
        }
        
        return new String(s);
    }
}