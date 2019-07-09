package leetcode.bits.com;

/**
 * Time: 2019-05-01
 * Author:snowy
 * leetcode 29: Divide Two Integers  位运算
 *
 * 注意点：使用位运算加快速度， 注意正负号以及边界情况
 *
 * */

public class DivideTwoIntegers_29 {
    public static int divideTwoInteger(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE - 1;

        boolean flag = ((dividend >= 0) == (divisor > 0));

        long divided = Math.abs((long) dividend);
        divisor = Math.abs(divisor);

        long res = 0;
        while(divided >= divisor) {
            // cur_divisor 当前的除数大小， 与当前除数对应的结果
            int cur_divisor = divisor, cur_res = 1;
            while(divided >= cur_divisor && cur_divisor >= 0){
                divided -= cur_divisor;
                res += cur_res;

                cur_divisor = cur_divisor << 1; // 除数乘2
                cur_res = cur_res << 1;         // 结果也乘2
            }
        }

        if(res > Integer.MAX_VALUE)
            res = flag ? Integer.MAX_VALUE : res;
        if(!flag)
            res =  -res;
        System.out.println(res);
        return Math.max(Integer.MIN_VALUE, Math.min((int)res, Integer.MAX_VALUE));
    }

    public static void main(String[] args) {
        int divided = -2147483648, divisor = 1;

        int res = divideTwoInteger(divided, divisor);
        System.out.println(res);
    }
}
