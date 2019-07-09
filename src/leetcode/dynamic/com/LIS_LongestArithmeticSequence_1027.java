package leetcode.dynamic.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Time: 2019-05-01
 * Author: snwoy
 * Leetcode 1027. Longest Arithmetic Sequence  动态规划的题，用一个hash数组记录一下以当前为节点的最长等差序列
 * */

public class LIS_LongestArithmeticSequence_1027 {
    public static int longestArithSeqLength(int[] A) {
        if(A.length < 1 && A == null)
            return 0;

        // 定义hash数组用于记录等差
        Map<Integer, Integer>[] arithmetic = new HashMap[A.length];
        for(int i = 0; i < A.length; i++){
            arithmetic[i] = new HashMap<>();
        }

        int longest = 0;

        // 从后向前遍历
        for(int i = A.length - 1; i >= 0; i --) {       // 以第i个数为起点

            for(int j = i + 1; j < A.length; j ++) {    //以第j个数为终点
                //注意此处的等差数组arithmetic的下标
                int len = arithmetic[j].containsKey(A[i] - A[j]) ? arithmetic[j].get(A[i] - A[j]) + 1 : 2;
                if(!arithmetic[i].containsKey(A[i] - A[j]))
                    arithmetic[i].put(A[i] - A[j], len);
                longest = Math.max(longest, len);
            }
            System.out.println(arithmetic[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] A = {44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28};
        int res = longestArithSeqLength(A);
        System.out.println(res);
    }
}
