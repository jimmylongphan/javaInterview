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
        int length1 = nums1.length;
        int length2 = nums2.length;
        if ((length1 + length2) % 2 == 0) {
            double r1 = (double) findMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2);
            double r2 = (double) findMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return findMedianSortedArrays(nums1, 0, length1, nums2, 0, length2, (length1 + length2 + 1) / 2);
    }

    public int findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int medianIndexLength) {
        int lengthA = endA - startA;
        int lengthB = endB - startB;

        if (lengthA <= 0)
            return B[startB + medianIndexLength - 1];
        if (lengthB <= 0)
            return A[startA + medianIndexLength - 1];
        if (medianIndexLength == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        // median of left array is smaller
        if (A[midA] <= B[midB]) {
            // adding the two halves is larger than our expected median length
            if (medianIndexLength <= ((lengthA + lengthB) / 2 + 1)) {
                // searching all of A
                // searching first half of B
                return findMedianSortedArrays(A, startA, endA, B, startB, midB, medianIndexLength);
            }
            else {
                // searching second half of A
                // searching all of B
                return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, medianIndexLength - (lengthA / 2) - 1);
            }
        } else {
            // median of left array is larger

            // adding the two halves is larger than our expected median length
            if (medianIndexLength <= (lengthA + lengthB) / 2 + 1) {
                // searching first half of A
                // searching all of B
                return findMedianSortedArrays(A, startA, midA, B, startB, endB, medianIndexLength);
            }
            else {
                // searching all of A
                // searching second half of B
                return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, medianIndexLength - (lengthB / 2) - 1);
            }

        }
    }
}
