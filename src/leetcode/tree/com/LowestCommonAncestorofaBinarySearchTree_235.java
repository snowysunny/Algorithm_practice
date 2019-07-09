package leetcode.tree.com;

public class LowestCommonAncestorofaBinarySearchTree_235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;

        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static TreeNode lowestCommonAncestor_iter(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;

        TreeNode node = root;

        while(node != null) {
            if(p.val < node.val && q.val < node.val)
                node = node.left;
            else if(p.val > node.val && q.val > node.val)
                node = node.right;
            else
                return node;
        }

        return null;
    }

    public static void main(String[] args) {
        String nodes = "[6,2,8,0,4,7,9,null,null,3,5]";
        String pVal = "[2]";
        String qVal = "[4]";
        TreeNode root = TreeNode.stringToTreeNode(nodes);
        TreeNode p = TreeNode.stringToTreeNode(pVal);
        TreeNode q = TreeNode.stringToTreeNode(qVal);
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
