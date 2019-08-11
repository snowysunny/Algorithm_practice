package special_topic.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Time: 2019-07-14
 * Author: snowy
 * 树的层次遍历
 * */

public class LevelorderTraversal_6 {

    // 层次遍历
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        levelOrderDfs(root, 0, res);
//        Collections.reverse(res);
        return res;
    }
    // 层次深度优先搜索
    public static void levelOrderDfs(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null)
            return;
        if(level >= res.size()) {
            res.add(new ArrayList<>());
        }
        // 之形打印
        if(level % 2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);

        levelOrderDfs(root.left, level + 1, res);
        levelOrderDfs(root.right, level + 1, res);
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
        List<List<Integer>> level_res = levelOrderTraversal(root);
        for(List<Integer> level : level_res)
            System.out.println(level);
    }
}
