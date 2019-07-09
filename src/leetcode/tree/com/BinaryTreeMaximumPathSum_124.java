package leetcode.tree.com;

/**
 * Time: 2019-06-28
 * Author: snowy
 * Leetcode 124: Binary Tree Maximum Path Sum
 * */

public class BinaryTreeMaximumPathSum_124 {

    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPath(TreeNode root) {
        if(root == null)
            return 0;

        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);

        maxSum = Math.max(left + right + root.val, maxSum);

        // 因为需要返回的是一条路径，所以是返回和较大的那条路径， 例子： [10,9,20,null,null,15,7]， 此时就不会包含7这个结点
        return Math.max(left, right) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;

        maxPath(root);
        return maxSum;
    }

    public static void main(String[] args) {
        String rootStr = "[1, 2, 3,  4 ]";
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        int res = maxPathSum(root);
        System.out.println(res);
    }
}
