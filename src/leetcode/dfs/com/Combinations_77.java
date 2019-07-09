package leetcode.dfs.com;

import leetcode.listnode.com.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-05-19
 * Author: snowy
 * Leetcode 77: Combinations
 * */

public class Combinations_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || n < 1 || k < 1)
            return res;

        List<Integer> path = new ArrayList<>();

        combineCore(n , k, 1, res, path);

        return res;
    }

//    递归
    public static void combineCore(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = start; i <= n; i ++) {
            list.add(i);
            combineCore(n, k - 1, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        List<List<Integer>> res = combine(n, k);
        for(List<Integer> list : res)
            System.out.println(list);
    }
}
