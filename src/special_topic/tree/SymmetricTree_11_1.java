package special_topic.tree;

import java.util.Stack;

/**
 * Time: 2019-07-15
 * Author: snowy
 * Leetcode 101: Symmetric Tree
 * */

public class SymmetricTree_11_1 {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymetricCore(root.left, root.right);
}

    public static boolean isSymetricCore(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;

        return isSymetricCore(left.left, right.right) && isSymetricCore(left.right, right.left);
    }

    // 迭代的方式
    public static boolean isSymmetric_iter(TreeNode root) {
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();

        // 每次push进去两个数据，pop出来也是两个数据
        if(root.left != null) {
            if(root.right == null)
                return false;
            stack.push(root.left);
            stack.push(root.right);
        } else if(root.right != null) {
            return false;
        }

        while(!stack.isEmpty()) {
            if(stack.size() % 2 != 0) {
                return false;
            }

            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if(left.val != right.val) {
                return false;
            }

            if(left.left != null) {
                if(right.right == null) {
                    return false;
                }

                stack.push(left.left);
                stack.push(right.right);
            } else if(right.right != null) {
                return false;
            }

            if(left.right != null) {
                if(right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if(right.left != null) {
                return false;
            }
        }

        return true;
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
        boolean res = isSymmetric_iter(root);
        System.out.println(res);
    }

}
