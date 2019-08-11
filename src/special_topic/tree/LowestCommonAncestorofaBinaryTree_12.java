package special_topic.tree;

import java.util.*;

/**
 * Time: 2019-07-15
 * Author: snowy
 * Leetcode 236: Lowest Common Ancestor of a Binary Tree  求二叉树的两个结点的最低公共祖先
 * */

public class LowestCommonAncestorofaBinaryTree_12 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }


    /**
     * 迭代实现
     * 1. 首先使用一个map记录下结点的parent结点
     * 2. 将p的祖先节点找出来放到一个set中
     * 3. 查找q的祖先节点，第一个出现在p的祖先节点set中的那个结点就为最低公共祖先节点
     */
    public static TreeNode lowestCommonAncestor_iter(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        parent.put(root, null);
        stack.push(root);

        while((!parent.containsKey(p) || !parent.containsKey(q)) && !stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();

        while(p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }

        while(!ancestor.contains(q) && q != null) {
            q = parent.get(q);
        }

        return q;
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
        TreeNode res = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(13));
        if(res == null)
            System.out.println(false);
        else
            System.out.println(res.val);
    }
}
