package com.javainterview.app.stringInterview;

import java.util.*;

/**
 * Strings are isomorphic if the letters in one word can be remapped to form the
 * second word.
 * 
 * Key notes:
 *   strings must have same length
 *   It is bidirectional, once you map one word, you can map the opposite direction
 */
public class Isomorphic {

    public boolean areIso( String s1, String s2 ) {
        if( s1 == null || s2 == null ) { 
            return false;
        } else if ( s1.length() != s2.length() ) {
            return false;
        }
        
        
        String s1Encoding = encode(s1);
        String s2Encoding = encode(s2);
        
        return s1Encoding == s2Encoding;
    }
    
    
    private String encode(String s) {
        Map<Character, Integer> charTracker = HashMap<Character, Integer>();
        String encoding = "";
        
        // loop through all characters
        for ( int i=0; i < s.length; i++) {
            char c = s.charAt(i);
            int pos;
            
            // if we've seen this character before, then we know we have mapped it
            if( charTracker.containsKey(c) ) {
                pos = charTracker.get(c);
            } else {
                // new character, so we will need to have a new mapping
                pos = i;
                charTracker.put(c, pos);
            }
            // shows that for each character, where we first created our mapping
            encoding += new String(pos);
        }
        
        return encoding;
    }
    
    
    public boolean areIsoHash(String s1, String s2) {
        if( s1 == null || s2 == null ) { 
            return false;
        } else if ( s1.length() != s2.length() ) {
            return false;
        }
        
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        
        for ( int i=0; i < s1.length(); i++ ) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if( map1.containsKey(c1) ) {
                // if mapping already exists
                // then the value must match the other character
                if( map1.get(c1) != c2 ) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
            }
            
            if( map2.containsKey(c2) ) {
                // if mapping already exists
                // then the value must match the other character
                if( map2.get(c2) != c1) ) {
                    return false;
                }
            } else {
                map2.put(c2, c1);
            }
        }
        
        // looped through entire string
        // did not see any discrepancy between the mappings
        return true;
    }
    
}