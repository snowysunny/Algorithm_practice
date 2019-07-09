package leetcode.dynamic.com;

import java.util.HashSet;
import java.util.Set;

/**
 * Time: 2019-07-02
 * Author: snowy
 * Leetcode 898: Bitwise ORs of Subarrays
 * */

public class BitwiseORsofSubarrays_898 {

    // [1, 2, 4] 为什么没有5， 是因为1 和 4 根本不是连续的呀，中间还有一个2 的
    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> pre = new HashSet<>();
        pre.add(0);

        for(int num : A) {
            Set<Integer> cur = new HashSet<>();
            cur.add(num);
            for(int prenum : pre) {
                cur.add(prenum | num);
            }

            res.addAll(cur);

            pre = cur;
            System.out.println(res);
        }

        return res.size();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int res = subarrayBitwiseORs(nums);
        System.out.println(res);
    }
}
