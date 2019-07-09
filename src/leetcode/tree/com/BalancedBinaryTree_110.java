package leetcode.tree.com;

/**
 * Time: 2019-06-15
 * Author: snowy
 * Leetcode 110: Balanced Binary Tree
 * */

public class BalancedBinaryTree_110 {
    public static boolean isBalanced(TreeNode root) {
        int res = treeHeight(root);

        return res >= 0;
    }

    public static int treeHeight(TreeNode root) {
        if(root == null)
            return 0;

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        if(Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
