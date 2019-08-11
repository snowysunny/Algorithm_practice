package special_topic.tree;

/**
 * Time: 2019-07-15
 * Author: snowy
 * Leetcode 543: Diameter of Binary Tree   求二叉树的直径： 二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根节点
 * */

public class DiameterofBinaryTree_13 {
    public static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        treeHeight(root);
        return max;
    }

    public static int treeHeight(TreeNode root) {
        if(root == null)
            return 0;

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
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
        int res = diameterOfBinaryTree(root);
        System.out.println(res);
    }
}
