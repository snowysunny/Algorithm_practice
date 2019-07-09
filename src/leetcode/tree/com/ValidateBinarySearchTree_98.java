package leetcode.tree.com;

import java.util.Stack;

/**
 * Time: 2019-05-28
 * Author: snowy
 * Leetcode 98: Validate Binary Search Tree
 * 中序遍历的思想
 * */

public class ValidateBinarySearchTree_98 {
    public static boolean isValidBST(TreeNode root) {
        int value = Integer.MIN_VALUE;
        int count = 0;

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(node.val <= value && count != 0) {
                return false;
            }

            value = node.val;

            node = node.right;
            count ++;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "[-2147483648]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        boolean res = isValidBST(root);
        System.out.println(res);
    }
}
