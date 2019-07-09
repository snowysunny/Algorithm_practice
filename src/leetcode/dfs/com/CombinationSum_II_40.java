package leetcode.dfs.com;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-05-06
 * Author: snowy
 * Leetcode 40: Combination Sum II
 * */

public class CombinationSum_II_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        combinationSum2Core(candidates, target, 0, list, res);
        return res;
    }

    public static void combinationSum2Core(int[] candidate, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if(target == 0) {
            if(!res.contains(list))
                res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidate.length; i ++) {
            if(target < candidate[i])
                break;
            list.add(candidate[i]);

            combinationSum2Core(candidate, target - candidate[i], i + 1, list, res);

            list.remove(list.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] candidate = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidate, target);
        for(List<Integer> list:res)
            System.out.println(list);
    }
}
