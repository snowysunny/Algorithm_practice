package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-05-06
 * Author: snowy
 * LeetCode 39: Combination Sum
 * 深度优先搜索
 * */

public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length < 1 || candidates == null)
            return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSumCore(candidates, target, 0, list, res);

        return res;
    }

    public static void combinationSumCore(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if(target == 0) {
//            res.add(list);
            // 要用new ArrayList 进行添加，不然添加进去为null
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = index; i < candidates.length; i ++) {
            if(target < candidates[i])
                break;
//            target = target - candidates[i];
            list.add(candidates[i]);
            combinationSumCore(candidates, target - candidates[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> res = combinationSum(nums, target);
        for(List<Integer> list : res)
            System.out.println(list);

    }
}
