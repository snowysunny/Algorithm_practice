package special_topic.tree;

/**
 * Time: 2019-07-15
 * Author: snowy
 * Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal
 * 由前序遍历序列和中序遍历序列重建二叉树
 * */

public class ConstructBinaryTreefromPreorderandInorderTraversal_14_1 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length < 1 || inorder.length < 1)
            return null;

        return buildTreeCore(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
}

    public static TreeNode buildTreeCore(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preorder.length - 1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;

        for(int i = inStart; i <= inEnd; i ++) {
            if(preorder[preStart] == inorder[i])
                index = i;
        }

        root.left = buildTreeCore(preorder, inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = buildTreeCore(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1 ,inEnd);

        return root;
    }

    public static TreeNode buildTree_in_post(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1)
            return null;

        return buildTreeCore_in_post(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode buildTreeCore_in_post(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = 0;
        for(int i = inStart; i <= inEnd; i ++) {
            if(postorder[postEnd] == inorder[i]) {
                index = i;
                break;
            }
        }

        root.left = buildTreeCore_in_post(inorder, postorder, inStart, index - 1, postStart, postEnd - inEnd + index - 1);
        root.right = buildTreeCore_in_post(inorder, postorder, index + 1, inEnd,  postEnd - inEnd + index, postEnd - 1);

        return root;
    }




    public static void main(String[] args) {
        int[] preorder = {5, 4, 11, 7, 2, 8, 13, 4, 1};
        int[] inorder = {7, 11, 2, 4, 5, 13, 8, 4, 1};
        /**
         *                          5
         *                    4          8
         *                11         13      4
         *             7      2                  1
         */
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.postOrder(root);
    }
}
