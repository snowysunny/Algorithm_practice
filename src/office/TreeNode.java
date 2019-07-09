package office;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {val = x;}
    TreeNode() {}

    /////////////////////////////树的遍历////////////////////////////////////////////

    // 树的先序遍历
    public static void preorder(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // 树的中序遍历
    public static void inorder(TreeNode root) {
        if(root != null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    // 树的后序遍历
    public static void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        }
    }

    // 树的先序遍历的非递归版本
    public static List<Integer> preorder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return res;

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            // 因为栈是先进后出，所以先将右结点压入栈中
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        System.out.println(Arrays.asList(res));
        return res;
    }

    // 树的后序遍历的非递归版本
    public static List<Integer> postorder_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null)
            return res;

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);

            if(node.left != null) {
                stack.push(node.left);
            }

            if(node.right != null) {
                stack.push(node.right);
            }
        }

        System.out.println(Arrays.asList(res));
        return res;
    }

    // 树的中序遍历的非递归版本
    public static List<Integer> inorder_iter(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            // 先将左结点压栈
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 逐个出栈，将结点添加到res中，并将其右孩子结点入栈
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        System.out.println(Arrays.asList(res));
        return res;
    }

    // 树的层次遍历
    public static List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelorder_helper(root, 0, list);
        return list;
    }
    public static void levelorder_helper(TreeNode node, int level, List<List<Integer>> list) {
        if (node != null) {
            if(level >= list.size()) {
                list.add(new ArrayList<>());
            }

            list.get(level).add(node.val);

            levelorder_helper(node.left, level + 1, list);
            levelorder_helper(node.right, level + 1, list);
        }
    }


    ///////////////////二叉树的构造////////////////////////
    public static TreeNode ConstructBinaryTreefromPreorderandInOrder(int[] preOrder, int[] inOrder) {
        return bulid_helper_PreorderandInOrder(0, 0, inOrder.length - 1, preOrder, inOrder);
    }

    public static TreeNode bulid_helper_PreorderandInOrder(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if(preStart > preOrder.length - 1 || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int index = 0;
        for (int i = inStart; i <= inEnd; i ++) {
            if(inOrder[i] == preOrder[preStart]) {
                index = i;
                break;
            }
        }

        root.left = bulid_helper_PreorderandInOrder(preStart + 1, inStart, index - 1 , preOrder, inOrder);
        root.right = bulid_helper_PreorderandInOrder(preStart + index - inStart + 1, index + 1, inEnd, preOrder, inOrder);

        return root;
    }

    public static TreeNode ConstructBinaryTreefromInOrderandPostOrder(int[] inOrder, int[] postOrder) {
        return bulid_helper_InOrderandPostOrder(postOrder.length - 1, 0, inOrder.length - 1, inOrder, postOrder);
    }

    public static TreeNode bulid_helper_InOrderandPostOrder(int postEnd, int inStart, int inEnd, int[] inOrder, int[] postOrder) {
        if(postEnd < 0 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i ++) {
            if(inOrder[i] == postOrder[postEnd]) {
                inIndex = i;
                break;
            }
        }

        root.left = bulid_helper_InOrderandPostOrder(postEnd - (inEnd - inIndex + 1), inStart, inIndex - 1, inOrder, postOrder);
        root.right = bulid_helper_InOrderandPostOrder(postEnd - 1, inIndex + 1, inEnd, inOrder, postOrder);
        return root;
    }

    public static TreeNode ConstructBinaryTreefromPreorderandPostorder(int[] preOrder, int[] postOrder) {
        return null;
    }

    public static TreeNode bulid_helper_PreOrderandPostOrder(int preStart, int postEnd, int[] preOrder, int[] postOrder) {
        if (preStart > preOrder.length - 1 || postEnd < 0)
            return null;

        return null;
    }



    ///////////////////////////////////////
    // TreeNode 的输入 例如：String input="[1,null,2,3]";
    public static TreeNode StringToTreeNode(String input) {
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

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] postOrder = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.ConstructBinaryTreefromPreorderandInOrder(preOrder, inOrder);
        postorder_iter(root);

        root = ConstructBinaryTreefromInOrderandPostOrder(inOrder, postOrder);
        preorder_iter(root);

        List<List<Integer>> res = levelorder(root);
        System.out.println(Arrays.asList(res));
    }
}
