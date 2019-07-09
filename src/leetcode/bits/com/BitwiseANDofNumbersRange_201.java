package leetcode.bits.com;

/**
 * Time: 2019-06-08
 * Author: snowy
 * Leetcode 201: Bitwise AND of Numbers Range
 * */

public class BitwiseANDofNumbersRange_201 {

    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for(; m != n; i ++) {
            m >>= 1;
            n >>= 1;
        }

        return n << i;
    }

    public static void main(String[] args) {
        int m = 5, n = 7;
        int res = rangeBitwiseAnd(m, n);
        System.out.println(res);
    }
}
