package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-05-07
 * Author: snowy
 * Leetcode 216: Combination Sum III
 *
 * */

public class CombinationSum_III_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k < 1 || k > 9 || n < 0)
            return res;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        combinationSum3Core( n, 1, new ArrayList<>(), res, k);


        return res;
    }

    // 比较简单的想法，就是根据第40题的思想，对其中的数组做长度筛选
    public static void combinationSum3Core(int target, int index, List<Integer> list, List<List<Integer>> res, int k) {
        if(k < 0)
            return;

        if(target == 0) {
            if(k == 0)
                res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i <= 9; i ++) {
            if(target < i)
                break;

            list.add(i);
            combinationSum3Core(target - i, i + 1, list, res, k - 1);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        int k = 3, n = 7;
        List<List<Integer>> res = combinationSum3(k, n);
        for(List<Integer> list : res)
            System.out.println(list);
    }
}
