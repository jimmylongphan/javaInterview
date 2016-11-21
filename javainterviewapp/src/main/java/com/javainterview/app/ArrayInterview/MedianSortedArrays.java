package com.javainterview.app.ArrayInterview;

/**
 * Created on 11/20/2016.
 *
 * LeetCode 4 Median of two sorted arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n.
 *
 * Find the median of the two sorted arrays. The run time complexisity should be O(log (m+n))
 *
 * Example 1:
 *   nums1 = [1, 3]
 *   nums2 = [2]
 *   The median is 2.0
 *
 * Example 2:
 *   nums1 = [1, 2]
 *   nums2 = [3, 4]
 *   The median is (2 + 3)/2 = 2.5
 *
 * Company: All
 *
 * Tags: Binary search, array, divide and conquer
 */
public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // if the total length is even
        boolean isEven = ((len1 + len2) % 2 == 0);

        // we want the larger array to be on the right side
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // calculate the average on the right side
        if (len1 == 0) {
            double average;
            if (isEven) {
                // add the two middle numbers of the right side
                average = nums2[len2/2] + nums2[len2/2 - 1];
                // calculate their average
                average /= 2.0;
            } else {
                // if it is not even, the return the middle of the right side
                average = (double) nums2[len2/2];
            }
            return average;
        }

        // start and end of the left array
        int start = 0, end = len1;

        // if the two arrays are one array, this is their middle index
        int mid = (len1+len2+1) / 2;

        while (start <= end) {
            // middle of left side and move right
            int i = start + (end - start) / 2;

            // middle of both arrays and move left
            int j = mid - i;

            if (j >= 1 && i < len1 && nums2[j-1] > nums1[i]) {
                start = i + 1;
            } else if (i >= 1 && j < len2 && nums1[i-1] > nums2[j] ) {
                end = i - 1;
            } else {
                int min_right = 0;
                int max_left = 0;

                if (j == 0) {
                    max_left = nums1[i-1];
                } else if (i == 0) {
                    max_left = nums2[j-1];
                } else {
                    max_left = Math.max(nums1[i-1], nums2[j-1]);
                }

                if (j == len2) {
                    min_right = nums1[i];
                } else if (i == len1) {
                    min_right = nums2[j];
                } else {
                    min_right = Math.min(nums1[i], nums2[j]);
                }

                if (isEven) {
                    return (min_right + max_left) / 2.0d;
                }
                return (double) max_left;
            }
        }

        return 0d;
    }
}
