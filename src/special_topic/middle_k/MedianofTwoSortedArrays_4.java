package special_topic.middle_k;

import java.util.Arrays;

/**
 * Time: 2019-07-22
 * Author: snowy
 * leetcode 4: Median of Two Sorted Arrays
 * 在两个有序数组中寻找中位数
 * */

public class MedianofTwoSortedArrays_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftMedian = (nums1.length + nums2.length + 1) / 2;
        int rightMedian = (nums1.length + nums2.length + 2) / 2;

        return (findKthSortedArray(nums1, nums2, 0, 0, leftMedian) + findKthSortedArray(nums1, nums2, 0, 0, rightMedian)) / 2;
    }

    public static double findKthSortedArray(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if(start1 > nums1.length - 1)
            return nums2[start2 + k - 1];
        if(start2 > nums2.length - 1)
            return nums1[start1 + k - 1];
        if(k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if(start1 + k / 2 - 1 < nums1.length)
            mid1 = nums1[start1 + k / 2 - 1];
        if(start2 + k / 2 - 1 < nums2.length)
            mid2 = nums2[start2 + k / 2 - 1];

        if(mid1 < mid2)
            return findKthSortedArray(nums1, nums2, start1 + k / 2, start2, k - k/2 );
        else
            return findKthSortedArray(nums1, nums2, start1, start2 + k /2, k - k/2);

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5};
        int[] nums2 = {3, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
