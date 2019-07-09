package leetcode.dynamic.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-06-27
 * Author: snowy
 * Leetcode 279: Perfect Squares
 * */

public class PerfectSquares_279 {

    // 动态规划的做法
    public static int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        while(list.size() <= n) {
            int m = list.size();
            int cur = Integer.MAX_VALUE;
            for(int i = 1; i * i <= m; i ++)
                cur = Math.min(cur, list.get(m - i * i) + 1);
            list.add(cur);
        }

        return list.get(n);
    }

    public static int numSquares_math(int n) {
        while(n % 4 == 0)
            n /= 4;

        if(n % 8 == 7)
            return 4;

        for(int i = 0; i * i < n; i ++) {
            int j = (int)Math.sqrt(n - i * i);
            if(i * i + j * j == n) {
                if(i == 0 || j == 0)
                    return 1;
                else
                    return 2;
            }
        }
        return 3;
    }

    public static void main(String[] args) {

        for(int i = 1; i <= 25; i ++) {
            int res = numSquares(i);
            System.out.println(res);
        }


    }
}
