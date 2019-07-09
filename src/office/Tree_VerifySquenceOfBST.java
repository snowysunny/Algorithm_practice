package office;

/**
 * Time: 2019-04-03
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * */


public class Tree_VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length <= 0)
            return false;

        return VerifySquenceOfBST_helper(sequence, 0, sequence.length - 1);

    }

    public static boolean VerifySquenceOfBST_helper(int[] sequence, int start, int end) {
        if(start >= end)
            return true;

        if(sequence == null || sequence.length <= 0 || start < 0 || end >= sequence.length)
            return false;

        // 找到开始比根结点大的那个结点的下标
        int low = start;
        for (; low < end; low ++) {
            if (sequence[low] > sequence[end])
                break;
        }

        // 从第一个比根结点大的那个结点开始后的每一个结点都必须比根结点大，如果违反了就返回false
        int high = low;
        for(; high < end; high ++) {
            if (sequence[high] < sequence[end])
                return false;
        }

        // 递归求解
        return VerifySquenceOfBST_helper(sequence, start, low - 1) && VerifySquenceOfBST_helper(sequence, low, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence = { 9, 11, 10, 8};
        boolean res = VerifySquenceOfBST(sequence);
        System.out.println(res);
    }
}
