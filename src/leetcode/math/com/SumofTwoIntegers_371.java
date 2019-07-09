package leetcode.math.com;

public class SumofTwoIntegers_371 {
    public static int getSum(int p, int q)
    {
        int result = p ^ q; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
        int carry = (p & q) << 1; // 1+1=2
        if (carry != 0) {
            return getSum(result, carry);
        }
        return result;
    }

    public static void main(String[] args) {
        int a = -2, b = 3;
        System.out.println(a ^ b);
    }
}
