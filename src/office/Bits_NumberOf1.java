package office;

/**
 * Time: 2019-03-19
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */

public class Bits_NumberOf1 {
    public int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '1')
                res ++;
        }
        return res;
    }

    public int NumberOf1_bit(int n) {
        int count = 0;

        while(n != 0) {
            count ++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        Bits_NumberOf1 count = new Bits_NumberOf1();
        int n = 10;
        int res = count.NumberOf1_bit(n);
        System.out.println(res);

        String s = "Hello World";
        System.out.println(s.charAt(2));

        System.out.println(1&2);

    }
}
