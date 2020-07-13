package com.javainterview.app.stringInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 12/10/2019.
 *
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true
 * if the ransom note can be constructed from the magazines
 * ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class Ransom {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rFreq = new HashMap<>();
        Map<Character, Integer> mFreq = new HashMap<>();

        for (int i=0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            rFreq.computeIfPresent(c, (k, v) -> v+1);
            rFreq.computeIfAbsent(c, v -> 1);
        }

        for (int i=0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            mFreq.computeIfPresent(c, (k, v) -> v+1);
            mFreq.computeIfAbsent(c, v -> 1);
        }

        // iterate through rFreq and check if freq are <= to magazine count
        for(Map.Entry<Character, Integer> entry : rFreq.entrySet()) {
            char key = entry.getKey();

            if (mFreq.getOrDefault(key, 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
