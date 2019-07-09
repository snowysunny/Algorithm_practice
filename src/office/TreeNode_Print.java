package office;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode_Print {
    public static ArrayList<ArrayList<Integer>> TreeNodePrint(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        Level_Print(pRoot, 0, lists);

        for (int i = 0; i < lists.size(); i ++) {
            if (i % 2 == 1) {
                Collections.reverse(lists.get(i));
            }
        }

        return lists;
    }

    public static void Level_Print(TreeNode pRoot, int level, ArrayList<ArrayList<Integer>> res) {
        if(pRoot == null)
            return;

        if (level >= res.size()){
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(pRoot.val);

        Level_Print(pRoot.left, level + 1, res);
        Level_Print(pRoot.right, level + 1, res);
    }

    public static void main(String[] args) {
        String node = "{8, 6, 9, 5, 7, 7, 5}";
        TreeNode root = TreeNode.StringToTreeNode(node);
        List<List<Integer>> res = TreeNode.levelorder(root);

        for(int i = 0; i < res.size(); i ++)
            System.out.println(res.get(i));

        ArrayList<ArrayList<Integer>> result = TreeNodePrint(root);
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}
