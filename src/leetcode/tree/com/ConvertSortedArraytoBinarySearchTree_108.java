package leetcode.tree.com;

/**
 * Time: 2019-06-12
 * Author: snwoy
 * Leetcode 108: ConvertSortedArraytoBinarySearchTree_108
 * */

import java.util.Arrays;

public class ConvertSortedArraytoBinarySearchTree_108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1)
            return null;

        int mid = nums.length / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return root;
    }

    public static void main(String[] args) {

    }
}
