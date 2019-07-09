package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences_967 {
    public static int[] numsSameConsecDiff(int N, int K) {

        List<Integer> list = new ArrayList<>();

        if(N == 1)
            list.add(0);

        for(int i = 1; i <= 9; i ++)
            dfsCore(N - 1, K, list, i);

        int[] res = new int[list.size()];

        for(int i = 0;  i < list.size(); i ++)
            res[i] = list.get(i);

        return res;
    }

    public static void dfsCore(int N, int K, List<Integer> res, int num) {
        if(N == 0) {
            res.add(num);
            return;
        }

        int cur = num % 10;

        if(cur - K >= 0)
            dfsCore(N - 1, K, res, num*10 + cur - K);

        if(K != 0 && cur + K <= 9)
            dfsCore(N - 1, K, res, num*10 + cur + K);
    }

    public static void main(String[] args) {
        int N = 2, K = 0;
        int[] res = numsSameConsecDiff(N, K);
        System.out.println(Arrays.toString(res));
    }
}
