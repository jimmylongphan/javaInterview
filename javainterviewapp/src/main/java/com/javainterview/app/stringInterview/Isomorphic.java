package com.javainterview.app.stringInterview;

import java.util.*;

/**
 * LeetCode: 205
 * Company: LinkedIn
 * Tags: Hash Table
 *
 * Strings are isomorphic if the letters in one word can be remapped to form the
 * second word.
 *
 * Key notes:
 * strings must have same length
 * It is bidirectional, once you map one word, you can map the opposite direction
 */
public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        // compare null and length
        if (s == null || t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }

        // create mappings for possible ASCII
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        // keep track of the encoding
        int count = 1;

        // both are same length now
        char sChar;
        char tChar;
        for (int i = 0; i < s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);

            // if their mappings are different
            if (m1[sChar] != m2[tChar]) {
                return false;
            }
            // new mapping
            if (m1[sChar] == 0) {
                m1[sChar] = count;
                m2[tChar] = count;
                count++;
            }
        }

        return true;
    }

    /**
     * Test if two strings are isomorphic using encoding method.
     * Two strings that are isomorphic should have the same encoding.
     * This is because the characters are mapped both ways.
     *
     * @param s1 string 1
     * @param s2 string 2
     * @return true if isomorphic
     */
    public boolean isIsomorphicEncoding(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }

        String s1Encoding = encode(s1);
        String s2Encoding = encode(s2);

        return s1Encoding.equals(s2Encoding);
    }

    /**
     * Encoding method
     * The idea is to encode the string such that.
     * We are marking each string with the index that it is first seen.
     * This is because we know that is when we created a mapping.
     *
     * The encoding of the other string should also match.
     * This is because when we encode one string, the other side gets encoded as well.
     * If the encoding does not match up, then we know that the mappings do not line up.
     *
     * Runtime: O(n)  but it is O(2n)
     * Space: O(n)  creating strings for each.
     *
     * @param s string to encode
     * @return the encoded string
     */
    private String encode(String s) {
        Map<Character, Integer> charTracker = new HashMap<Character, Integer>();
        String encoding = "";

        // loop through all characters
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pos;

            // if we've seen this character before, then we know we have mapped it
            if (charTracker.containsKey(c)) {
                pos = charTracker.get(c);
            } else {
                // new character, so we will need to have a new mapping
                pos = i;
                charTracker.put(c, pos);
            }

            // shows that for each character, where we first created our mapping
            encoding += Integer.toString(pos);
        }

        return encoding;
    }


    /**
     * Check if both strings are isomorphic.
     * We are looping through both strings and creating our mappings
     * at the same time.
     *
     * However, we check if there is an existing mapping.
     * If it exists, then we must check that their mappings match.
     *
     * If they do not match, then they are not isomorphic
     *
     * @param s1 first string
     * @param s2 second string
     * @return if mappings match
     */
    public boolean areIsoHash(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (map1.containsKey(c1)) {
                // if mapping already exists
                // then the value must match the other character
                if (map1.get(c1) != c2) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                // if mapping already exists
                // then the value must match the other character
                if (map2.get(c2) != c1) {
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