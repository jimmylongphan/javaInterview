package com.javainterview.app.stringInterview;

import java.util.*;

/**
 * Segment a string such that it can be divided into twitter messages
 * Each message is at most 140 characters
 * Can only segment at a whitespace.
 * Words themselves are not longer than 140 characters.
 * 
 * Return a list of string
 */
public class Segment {
   
   public List<String> segment( String s, int messageLength ) {
       List<String> result = new ArrayList<String>();
       
       // error checking
       if(s == null || s.isEmpty()) {
           return result;
       }
       
       // keep track of the start index
       int start = 0;
       
       // keep track of the end
       int end = s.length() - 1;
       
       // loop through the string
       while( start < end ) {
            // create message from index
            int index = start + messageLength;

            // check if we are at the end of the input
            // if so, then add the remaining substring and break
            if( index > end) {
                output.add(s.substring(start,end));
                break;
            }
            
            // if the break is not a whitespace
            // move the end back until we see whitespace
            while( s.charAt(index) != ' ' ) {
                --index;
                if( index == start ) {
                    break;
                }
            }

            // error check if there are no available spaces
            if( index == start ) {
                break;
            }
            
            // at this point we should have an index at a whitespace
            output.add( s.substring(start,index) );
            
            // move the start to the next character
            start = index+1;
       }  // end while
       
       return result;
   }
}