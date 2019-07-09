package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.List;

public class Combinations_Subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 1)
            return res;

        subsetCore(nums, 0, res, new ArrayList<>());

        return res;
    }

    public static void subsetCore(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {

        res.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i ++) {
            path.add(nums[i]);
            subsetCore(nums, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        for(List<Integer> list : res)
            System.out.println(list);
    }
}
