package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2_90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 1)
            return res;

        Arrays.sort(nums);
        subsetCore(nums, 0, res, new ArrayList<>());

        return res;
    }

    public static void subsetCore(int[] nums, int start, List<List<Integer>> res, List<Integer> path) {
//        if(!res.contains(path))
            res.add(new ArrayList(path));

        for(int i = start; i < nums.length; i ++) {
            if(i > start && nums[i] == nums[i - 1])         // 加快速度
                continue;
            path.add(nums[i]);
            subsetCore(nums, i  + 1, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> res = subsetsWithDup(nums);
        for(List<Integer> list : res)
            System.out.println(list);
    }
}
