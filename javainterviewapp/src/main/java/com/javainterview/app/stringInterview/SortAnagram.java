package com.javainterview.app.stringInterview;

import java.util.*;

public class SortAnagram {

    /**
     * This solution uses the comparable interface for Anagrams
     * When inserting an Anagram, the Priority Queue will utilize the compareTo method to
     * order the elements.
     * Space O(n):  using two data structures, but one will be emptied
     * Runtime O(log n): Using the poll methods
     *
     * Taking advantage of priority queues benefits of retrieving highest value.
     */
    public List<String> sortWithPriority(List<String> in) {
        List<String> result = new ArrayList<String>();

        PriorityQueue<Anagram> anaQ = new PriorityQueue<Anagram>();
        // insert all elements into the priority queue
        for (String s : in) {
            anaQ.add(new Anagram(s));
        }

        // the poll method will retrieve the head of the queue
        // which will be the largest value determined by the String compareTo method
        while (!anaQ.isEmpty()) {
            result.add(anaQ.poll().getValue());
        }

        return result;
    }

    /**
     * This solution uses a list containing all of the keys and their values
     * Space O(n): Storing elements in a result map
     * Runtime O(2n): O(n) linear because looping through all keys and values
     *
     * More complicated structure due to using a list within a map.
     */
    public List<String> sortWithMap(List<String> in) {
        Map<String, List<String>> values = new HashMap<String, List<String>>();

        for (String s : in) {
            // generate keys
            Anagram anagram = new Anagram(s);
            String key = anagram.getKey();

            // add the values
            List<String> queue;
            if (values.containsKey(key)) {
                queue = values.get(key);
            } else {
                // push into the values
                queue = new ArrayList<String>();
                values.put(key, queue);
            }
            queue.add(s);
        }

        // loop through all values, print out values
        // all the anagrams should now be grouped together
        List<String> result = new ArrayList<String>();
        for (List<String> queue : values.values()) {
            result.addAll(queue);
        }

        return result;
    }

}