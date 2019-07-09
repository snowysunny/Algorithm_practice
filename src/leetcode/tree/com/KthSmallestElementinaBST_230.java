package leetcode.tree.com;

import java.util.Stack;

/**
 * Time: 2019-06-19
 * Author: snowy
 * Leetcode 230: Kth Smallest Element in a BST
 * 中序遍历
 * */

public class KthSmallestElementinaBST_230 {

    public static int KthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            k --;

            if(k == 0)
                return node.val;

            node = node.right;

        }

        return -1;

    }

    public static void main(String[] args) {
        String rootStr = "[3,1,4,null,2]";
        int k = 3;
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        int res = KthSmallest(root, k);
        System.out.println(res);
    }
}
