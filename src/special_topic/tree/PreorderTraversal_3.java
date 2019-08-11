package special_topic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Time: 2019-07-12
 * Author: snowy
 * 树的先序遍历
 * */

public class PreorderTraversal_3 {

    // 进行先序遍历的递归写法
    public static void preorder_cur(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + "  ");
            preorder_cur(root.left);
            preorder_cur(root.right);
        }
    }

    // 迭代写法
    public static List<Integer> preorder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if(node.right != null)
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);
        }

        return res;
    }

    /**
     * 先序遍历
     * 1. 如果当前结点的左孩子为null，则输出当前结点，并将指针意移向当前结点的右孩子
     * 2. 如果当前结点的左孩子不为空，在当前结点的左子树上找到当前结点的在中序遍历下的前驱节点
     * （a） 如果前驱节点的右孩子为空，将该前驱节点的右孩子设置为当前结点。输出当前结点（这里是和中序遍历唯一不同的地方），当前结点指向当前结点的左孩子
     * （b） 如果前驱节点的右孩子为当前结点，将它的右孩子重新设为null（恢复原来的树）。当前结点的更新为当前结点的右孩子
     * 3. 重复1/2直到当前结点为空
     * */
    public static List<Integer> preorder_morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        TreeNode cur = root, prev = null;

        while(cur != null) {
            if(cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                }
                if(prev.right == cur) {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        preorder_cur(root);
        System.out.println("");
        List<Integer> iter_res = preorder_iter(root);
        System.out.println(iter_res);
        List<Integer> morris_res = preorder_morris(root);
        System.out.println(morris_res);
    }
}
