package special_topic.tree;

import java.util.Stack;

/**
 * Time: 2019-07-15
 * Author: snowy
 * Leetcode 226: 反转二叉树/ 二叉树的镜像
 * */

public class InvertBinaryTree_11 {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.left = right;

        return root;
    }

    public static TreeNode invertTree_iter(TreeNode root) {
        if(root == null)
            return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(! stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

        return root;
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
//        System.out.println(TreeNode.preOrder_iter(invertTree(root)));

        System.out.println(TreeNode.preOrder_iter(invertTree_iter(root)));
    }
}
