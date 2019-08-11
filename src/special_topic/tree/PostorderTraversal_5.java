package special_topic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Time: 2019-07-12
 * Author: snowy
 * 后序遍历
 * */

public class PostorderTraversal_5 {

    public static void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static List<Integer> postorder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(! stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }

        return res;
    }

    public static void main(String[] args) {
        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(rootStr);
        postorder(root);
        System.out.println("");
        List<Integer> iter_res = postorder_iter(root);
        System.out.println(iter_res);
    }
}
