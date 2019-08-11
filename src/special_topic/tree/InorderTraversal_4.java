package special_topic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Time: 2019-07-12
 * Author: snowy
 * 中序遍历， 三种不同的方法， 第一种是递归， 2. 非递归，空间复杂度为O(n)  3. 非递归， 空间复杂度为O(1)， Morris写法
 * */

public class InorderTraversal_4 {
    public static void inorder_curr (TreeNode root) {
        if(root != null) {
            inorder_curr(root.left);
            System.out.print(root.val + " ");
            inorder_curr(root.right);
        }
    }

    // 非递归写法
    public static List<Integer> inorder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

    /**
     * 中序遍历
     * 1. 如果当前结点的左孩子为null，则输出当前结点，并将指针意移向当前结点的右孩子
     * 2. 如果当前结点的左孩子不为空，在当前结点的左子树上找到当前结点的在中序遍历下的前驱节点
     * （a） 如果前驱节点的右孩子为空，将该前驱节点的右孩子设置为当前结点。当前结点指向当前结点的左孩子
     * （b） 如果前驱节点的右孩子为当前结点，将它的右孩子重新设为null（恢复原来的树）。输出当前结点。当前结点的更新为当前结点的右孩子
     * 3. 重复1/2直到当前结点为空
     * */
    // Morris中序遍历
    public static List<Integer> inorder_morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        TreeNode cur = root, prev = null;
        while(cur != null) {
            if(cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else{
                prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }
                if(prev.right == cur) {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        inorder_curr(root);
        System.out.println("");
        List<Integer> iter_res = inorder_iter(root);
        System.out.println(iter_res);
        List<Integer> morris_res = inorder_morris(root);
        System.out.println(morris_res);
    }
}
