package special_topic.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x; }

    // 构建树     input = [1, 2, null, 4, 5]
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];

        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    // 前序遍历（递归的方式）
    public static void preOrder(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

//    先序遍历——迭代法
    public static List<Integer> preOrder_iter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        
        Stack<TreeNode> stack = new Stack<>();  // 使用栈实现

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            list.add(node.val);

            if(node.right != null)      // 右子节点先进栈
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);
        }

        return list;
    }

    // 中序遍历
    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    // 中序遍历——非递归
    public static List<Integer> inOrder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            // 先将左结点压栈
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }


            cur = stack.peek();
            res.add(cur.val);
            stack.pop();

            cur = cur.right;

        }
        return res;
    }

    // 后序遍历
    public static void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    // 后序遍历——非递归
    public static List<Integer> postOrder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 插入时头插
            res.add(0, node.val);

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }

        return res;
    }

    public static void main(String[] args) {
        String input = "[5,1,4,null,null,3,6]";
        TreeNode root = stringToTreeNode(input);

        List<Integer> res = postOrder_iter(root);
        System.out.println(res);
        postOrder(root);
    }



}
