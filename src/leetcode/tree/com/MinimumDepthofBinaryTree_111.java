package leetcode.tree.com;

/**
 * Time: 2019-06-20
 * Author: snowy
 * Leetcode 111: Minimum Depth of Binary Tree
 * */

public class MinimumDepthofBinaryTree_111 {

    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }

    public static void main(String[] args) {
        String nodes = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(nodes);
        int res = minDepth(root);
        System.out.println(res);
    }
}
