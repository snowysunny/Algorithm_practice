package leetcode.math.com;

/**
 * Time: 2019-07-06
 * Author: snowy
 * Leetcode 204: Count Primes
 * */

public class CountPrimes_204 {
    public static int countPrimes(int n) {
        if(n <= 2)
            return 0;

        boolean[] flag = new boolean[n];
        int count = 0;

        for(int i = 2; i < n; i ++) {
            if(flag[i] == false)
                count ++;

            for(int j = 2; j <= i && i * j < n; j ++)
                flag[i * j] = true;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        int res = countPrimes(n);
        System.out.println(res);
    }
}
