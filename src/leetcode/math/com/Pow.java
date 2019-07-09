package leetcode.math.com;

/**
 * Time: 2019-05-11
 * Author: snowy
 * Leetcode 50: Po(x, n)
 * */

public class Pow {
    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        double res = myPow(x, n/2);     // 递归实现

        if(n % 2 == 0) {
            return res * res;
        } else {
            if(n > 0)
                return res * res * x;
            else
                return res * res / x;
        }
    }

    public static void main(String[] args) {
        double x= 2.0;
        int n = -2;
        System.out.println(myPow(x, n));
    }
}
