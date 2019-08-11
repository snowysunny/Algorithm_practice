package special_topic.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Time:
 * */

public class SerializeandDeserializeBinaryTree_297 {
    // 先序遍历结果
    public static String serialize(TreeNode root) {
        if(root == null)
            return "null,";

        StringBuffer buffer = new StringBuffer(root.val + ",");
        buffer.append(serialize(root.left));
        buffer.append(serialize(root.right));

        return buffer.toString();
    }

    public static TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;

        String[] parts = data.substring(1, data.length() - 1).split(",");

        Queue<String> queue = new LinkedList<>();
        for(String str : parts)
            queue.offer(str);

        return bulidTree(queue);
    }

    public static TreeNode bulidTree(Queue<String> queue) {
        if(queue.isEmpty())
            return null;
        String val = queue.poll();
        if(val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = bulidTree(queue);
        node.right = bulidTree(queue);
        return node;
    }

    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> postres = new ArrayList<>();
        if(root == null)
            return postres;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postres.add(0, node.val);

            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }

        return postres;
    }

    public static void main(String[] args) {
//        String rootStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
//        TreeNode root = deserialize(rootStr);
        String rootStr = "[5,4,11,7,null,null,2,null,null,null,8,13,null,null,4,null,1,null,null]";
        /**
         *                          5
         *                    4          8
         *                11         13      4
         *             7      2                  1
         */
        TreeNode root = deserialize(rootStr);
        List<Integer> postres = postOrder(root);

        System.out.println(postres);
//        List<List<Integer>> lveelRes =

        String seri = serialize(root);
        System.out.println(seri);
    }
}
