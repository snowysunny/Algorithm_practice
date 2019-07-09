package office;

/**
 * Time: 2019-04-16
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * */


public class Add {
    public static int Add(int num1, int num2) {
        int sum = 0, carry = 0;

        while(num2 != 0) {
            sum = num1 ^ num2;              // 异或求和
            carry = (num1 & num2) << 1;     // 与用来求进位

            num1 = sum;
            num2 = carry;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num1 = 5, num2 = 17;
        int res = Add(num1, num2);
        System.out.println(res);
    }
}
