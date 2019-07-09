package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-05-09
 * Author: snowy
 * Leetcode 996: Number of Squareful Arrays
 * 重要思想还是深度优先搜索，重点参考46题，这是一类题目
 * */

public class NumberofSquarefulArrays_996 {
    public static int numSquarefulPerms(int[] A) {
        if(A == null || A.length < 1)
            return 0;
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[A.length];

        numSquarefulPermsCore(A, new ArrayList<>(), res, visited);

        for(List<Integer> list:res)
            System.out.println(list);
        return res.size();
    }

    public static void numSquarefulPermsCore(int[] A, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if(list.size() == A.length) {
                res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < A.length; i ++) {
            if(visited[i] || i > 0 && A[i] == A[i - 1] && !visited[i - 1])
                continue;

            if(list.size() > 0 && Math.sqrt(list.get(list.size() - 1) + A[i]) - (int)Math.sqrt(list.get(list.size() - 1) + A[i]) >= 1e-6)       //相对于第46题加上的判断
                continue;

            list.add(A[i]);
            visited[i] = true;
            numSquarefulPermsCore(A, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 8};
        int res = numSquarefulPerms(nums);
        System.out.println(res);
    }
}
