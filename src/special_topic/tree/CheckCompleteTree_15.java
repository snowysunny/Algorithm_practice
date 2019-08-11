package special_topic.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: 2019-07-16
 * Author: snowy
 * 判断二叉树是不是完全二叉树
 * */

public class CheckCompleteTree_15 {

    public static boolean checkCompleteTree(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = true;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                if(flag == false)       // 说明之前已经出现过叶子结点了，在叶子结点之后还有非null结点说明不是完全二叉树
                    return false;
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                flag = false;
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
        boolean res = checkCompleteTree(root);
        System.out.println(res);
    }
}
