package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-05-09
 * Author: snowy
 * Leetcode 46: Permutations
 * */

public class Permutations_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 1 || nums == null)
            return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];           // 用于记录是否已经访问过了
        permuteCore(nums, new ArrayList<>(), res, visited);
        return res;
    }

    public static void permuteCore(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if(list.size() == nums.length) {
//            if(!res.contains(list)) {
                res.add(new ArrayList<>(list));
//            }
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i - 1])          // 是否已经访问过，访问过则跳过
                continue;
            list.add(nums[i]);
            visited[i] = true;
            permuteCore(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> list:res)
            System.out.println(list);


        System.out.println(Math.sqrt(6) - (int)Math.sqrt(5) <= 1e-6);
    }
}
