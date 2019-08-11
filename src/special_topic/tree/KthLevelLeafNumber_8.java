package special_topic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-07-15
 * Author: snowy
 * 求二叉树第K层的叶子结点的个数
 * */

public class KthLevelLeafNumber_8 {

    public static int kthLevelLeafNumber(TreeNode root, int k) {
        if(root == null)
            return 0;

        if(k == 1) {
            if(root.left == null && root.right == null)
                return 1;
            else
                return 0;
        }

        return kthLevelLeafNumber(root.left, k - 1) + kthLevelLeafNumber(root.right, k - 1);
    }

    public static int get_kth_level_leaf_number(TreeNode root, int k) {
        if(root == null)
            return 0;

        List<Integer> res = new ArrayList<>();
        kthLevelLeafNumberCore(root, k, res);
        return res.size();
    }

    public static void kthLevelLeafNumberCore(TreeNode root, int k, List<Integer> res) {
        if(root == null)
            return;

        if(k == 1) {
            if(root.left == null && root.right == null)
                res.add(root.val);
//            System.out.println(res);
            return;
        }

        kthLevelLeafNumberCore(root.left, k - 1, res);
        kthLevelLeafNumberCore(root.right, k - 1, res);
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
        int res = kthLevelLeafNumber(root, 4);
        System.out.println(res);
        int res1 = get_kth_level_leaf_number(root, 4);
        System.out.println(res1);
    }
}
