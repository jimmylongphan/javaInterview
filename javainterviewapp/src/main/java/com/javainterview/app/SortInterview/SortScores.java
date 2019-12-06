package com.javainterview.app.SortInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * O(highest_possible_score * n)
 *
 * Tags: Google Foobar, sort, list
 *
 * O(n lg n)
 * n = 100
 * lg n =
 */
public class SortScores {
    public static List<Integer> sort_scores(List<Integer> unsorted_scores, int highest_possible_score) {
        Map<Integer, Integer> counts = new HashMap<>();

        // updates counts of scores for each
        // O(n)
        for (Integer score : unsorted_scores) {
            if (counts.containsKey(score)) {
                counts.put(score, counts.get(score) + 1);
            } else {
                counts.put(score, 1);
            }
        }

        List<Integer> results = new ArrayList<>();

        // O(highest_possible_score)
        // iterate through highest score down to 0
        // if that value exists in counts
        // then add the number of occurrences for that count
        for (int i = highest_possible_score; i >= 0; i--) {
            if (counts.containsKey(i)) {
                // O(n)
                for (int j = 0; j < counts.get(i); j++) {
                    results.add(i);
                }
            }
        }
        return results;
    }

}

/**
 * # Python
 * import collections
 *
 * def sort_scores(unsorted_scores, highest_possible_score):
 * score_frequencies = collections.Counter(unsorted_scores)
 *
 * sorted_scores = []
 * for score in reversed(range(0, highest_possible_score + 1)):
 * if score in score_frequencies:
 * for _ in range(score_frequencies[score]):
 * sorted_scores.append(score)
 *
 * return sorted_scores
 **/