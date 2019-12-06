package com.javainterview.app.ArrayInterview;

/**
 * Use binary search to find a rotation point in an array
 *
 * Google Foobar 1
 *
 * 0         1        2        3        4
 * "grape", "orange", "plum", "radish", "apple"}
 *
 * 3 cases (aka where can "apple" be)
 * no rotation = rotation at beginning
 * apple - plum - radish
 * apple < plum < radish ==> done
 * rotation at end
 * the word I'm scanning has a bigger word on my immediate left
 *
 * grape - plum - apple
 * grape < plum ==> rotation somewhere on the right
 * rotation at middle
 * the word I'm scanning has a bigger word on my immediate left
 * grape - apple - plum
 * grape < apple ==>
 */
public class ArrayBinarySearch {
    public static int findRotationPoint(String[] words) {
        // check if no rotation
        int length = words.length;
        int middle = getMiddle(0, length - 1);
        // check if leftmost and middle and rightmost fit
        if (words[0].compareTo(words[middle]) < 0 && words[length - 1].compareTo(words[middle]) > 0) {
            return -1;
        }

        // edge case
        // check rightmost word
        // if rightmost < rightmost - 1, then rotation is length - 1
        // check end case rightmost is less than immediate left
        int l = length;
        if (words[l - 2].compareTo(words[l - 1]) > 0) {
            return l - 1;
        }

        // traditional case
        // rotation point is somewhere in the middle
        return findHelper(words, 0, length - 1);
    }

    /**
     * Helper method to get middle of 2 points
     *
     * @param left  left index
     * @param right right index
     * @return middle index
     */
    public static int getMiddle(int left, int right) {
        int middle = left + (right - left) / 2;
        return middle;
    }

    public static int findHelper(String[] words, int left, int right) {
        // get the middle word
        int middle = getMiddle(left, right);
        String mw = words[middle];

        // get the left and right words
        String lw = words[left];
        String rw = words[right];

        // check if the middle is the point
        // base case
        // immediate left is larger
        if (middle > 0 && words[middle - 1].compareTo(mw) > 0) {
            return middle;
        }

        if (lw.compareTo(mw) < 0) {
            // leftmost is less than middle
            // go right
            return findHelper(words, middle + 1, right);
        } else if (rw.compareTo(mw) <= 0) {
            // rightmost is less than middle
            // go left
            return findHelper(words, left, middle - 1);
        } else {
            return middle;
        }
    }
}

/**
 * # Python
 * def find(word_list, start, end):
 * midpoint = start + (end - start) / 2
 *
 * top = word_list[start]
 * mid = word_list[midpoint]
 * bot = word_list[end]
 *
 * if top < mid and mid < bot:
 * return mid
 * else:
 * if top > mid:
 * return find(word_list, start, midpoint)
 * else:
 * return find(word_list, midpoint, end)
 *
 * def find_rotation_point(words):
 * return find(words, 0, len(words) - 1)
 */