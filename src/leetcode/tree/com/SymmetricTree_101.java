package leetcode.tree.com;

/**
 * Time: 2019-06-06
 * Author: snowy
 * Leetcode 101: Symmetric Tree
 * */

public class SymmetricTree_101 {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return false;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;

        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        String input = "[1,2,2,3,4,4,3]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        boolean res = isSymmetric(root);
        System.out.println(res);
    }
}
