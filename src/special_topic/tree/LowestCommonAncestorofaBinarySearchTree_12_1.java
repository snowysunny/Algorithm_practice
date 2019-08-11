package special_topic.tree;

import java.util.Stack;

/**
 * Time: 2019-07-15
 * Author: snowy
 * Leetcode 235: Lowest Common Ancestor of a Binary Search Tree   二叉索引树的最低公共祖先节点
 */

public class LowestCommonAncestorofaBinarySearchTree_12_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }


    // 迭代的方式
    public TreeNode lowestCommonAncestor_iter(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(p.val < node.val && q.val < node.val) {
                stack.push(node.left);
            } else if(p.val > node.val && q.val > node.val) {
                stack.push(node.right);
            } else
                return node;
        }

        return root;
    }
}
