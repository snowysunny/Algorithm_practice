package office;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

/**
 * Time: 2019-04-02
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */


public class Tree_PrintFromTopToBottom {
    /**
     * 我的思路很简单就是二叉树的层次遍历
     */

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();     // 分层存放

        levelTravel(root, 0, list);

        for(ArrayList<Integer> num : list) {
            res.addAll(num);
        }

        return res;
    }

    /**
     * @param root
     * @param level 树的层次
     * @param list  用于存储每一层的节点
     * */
    public static void levelTravel(TreeNode root, int level, ArrayList<ArrayList<Integer>> list) {
        if(root == null)
            return;

        if(list.size() <= level) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);

        levelTravel(root.left, level + 1, list);
        levelTravel(root.right, level + 1, list);
    }

    // 树的层次遍历的非递归版本
    public static ArrayList<Integer> PrintFromTopToBottom_iter(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        Deque<TreeNode> deque = new LinkedList<>();         // 队列用于记录结点   add(E e)：添加一个元素到队尾   poll()：获取队首的元素，并从队列中移除   peek()：获取队首的元素，但不从队列中移除

//        ((LinkedList<TreeNode>) queue).push(root);
        deque.add(root);
        while(!deque.isEmpty()) {
            TreeNode node = deque.pop(); //((LinkedList<TreeNode>) queue).pop();
            res.add(node.val);
            if(node.left != null)
                deque.add(node.left);
//                ((LinkedList<TreeNode>) queue).push(node.left);

            if(node.right != null)
                deque.add(node.right);
//                ((LinkedList<TreeNode>) queue).push(node.right);
        }

        return res;

    }

    public static void main(String[] args) {
        String stringRoot = "[8, 10, 6, 11, 9, 7, 5]";
        TreeNode root = TreeNode.StringToTreeNode(stringRoot);
        ArrayList<Integer> res = PrintFromTopToBottom_iter(root);
        System.out.println(res);
    }

}
