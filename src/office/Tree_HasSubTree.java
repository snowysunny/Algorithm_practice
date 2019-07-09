package office;

/**
 * Time: 2019-04-01
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */

public class Tree_HasSubTree {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val)
                //以这个根节点为为起点判断是否包含Tree2
                result = DoesTree1HasTree2(root1, root2);
            //如果找不到，那么就再去root的左儿子或者右儿子当作起点，去判断时候包含Tree2
            if(!result)
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

        }
        //返回结果
        return result;
    }

    public static boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {

    }
}
