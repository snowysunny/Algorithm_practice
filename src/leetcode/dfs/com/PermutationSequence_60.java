package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2009-05-15
 * Author: snowy
 * Leetcode 60: Permutation Sequence
 * */

public class PermutationSequence_60 {
    // 递归方式求解，这种解法主要参考leetcode46题，哎
    public static String getPermutation_recursion(int n, int k) {
        if(n < 1 || n > 9 || k < 1)
            return null;

        List<String> lists = new ArrayList<>();

        boolean[] visited = new boolean[n];             // 定义是否已经访问过了
        getPermutationCore(n, "", lists, visited);
        System.out.println(lists);

        return lists.get(k - 1);
    }

    // 这道题过时间了，哎
    public static void getPermutationCore(int n, String str, List<String> res, boolean[] visited) {
        if(str.length() == n) {
            res.add(str);
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(visited[i])          // 是否已经访问过，访问过则跳过
                continue;
            visited[i] = true;
            getPermutationCore(n, str + (i + 1), res, visited);
            visited[i] = false;
        }
    }


    // 使用迭代的方式进行求解吧
    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i ++)
            nums.add(i);
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i ++)
            fact[i] = fact[i - 1] * i;

        k = k - 1;
        StringBuffer strbuf = new StringBuffer();

        for(int i = n - 1; i >= 0; i --) {       // 遍历n确定挑n中的那个数加入到strbuf中
            int index = k / fact[i];             // 当前应加入数组中的第几个数
            k = k % fact[i];                     // 剩下的里面的第几个
            strbuf.append(nums.get(index));
            nums.remove(index);
        }

        return strbuf.toString();
    }





    public static void main(String[] args) {
        int n = 4, k = 9;
        String res = getPermutation(n, k);
        System.out.println(res);
    }
}
