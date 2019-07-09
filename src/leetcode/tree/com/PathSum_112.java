package leetcode.tree.com;

/**
 * Time: 2019-06-23
 * Author: snowy
 * Leetcode 112: Path Sum
 * */

public class PathSum_112 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null && sum == root.val)
            return true;


        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        boolean res = hasPathSum(root, 22);
        System.out.println(res);
    }
}
