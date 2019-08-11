package special_topic.tree;

/**
 * Time: 2019-07-15
 * Author: snowy
 * 判断二叉树是不是平衡二叉树
 * */

public class BalancedBinaryTree_10 {
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if(Math.abs(left - right) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int treeHeight(TreeNode root) {
        if(root == null)
            return 0;

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left , right) + 1;
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        /**
         *                          5
         *                    4          8
         *                11         13      4
         *             7      2                  1
         */
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        boolean res = isBalanced(root);
        System.out.println(res);
    }
}
