package leetcode.math.com;

/**
 * Time: 2019-05-27
 * Author: snowy
 * Leetcode 69: Sqrt(x)
 * 二分法的思想，需要进行改进
 * */

public class Sqrt_69 {
    public static int mySqrt(int x) {
        if(x <= 0)
            return 0;

        int left = 1, right = x, res = 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(mid > x / mid)
                right = mid;
            else {
                res = mid;
                left = mid + 1;
            }

        }

        return res;
    }

    public static int mysqrt(int x) {
        if(x <= 0)
            return 0;

        int res = x / 2;
        while(res > x / res) {
            res = (res + x / res) / 2;              // 牛顿法计算出来的例子
        }

        return res;
    }

    public static void main(String[] args) {

        int x = 2147395599;
        int res = mySqrt(x);
        System.out.println(res);
//        System.out.println();
        int res1 = mysqrt(x);
        System.out.println(res1);
    }
}
