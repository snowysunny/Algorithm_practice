package special_topic.tree;

/**
 * Time: 2019-07-16
 * Author: snowy
 * 判断树B是否是树A的子结构
 * */

public class HasSubtree_16 {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        return isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        // root2 == null 的判断要在root1==null的前面进行判断

        if(root2 == null)
            return true;

        if(root1 == null)
            return false;

        if(root1.val == root2.val)
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);

        return false;
    }

    public static void main(String[] args) {

    }
}
