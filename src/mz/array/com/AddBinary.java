package mz.array.com;

/**
 * Time: 2018-10-06    Author: Snowy
 * Leetcode 67题， 二进制加法
 * */
public class AddBinary {
    //自己写的比较愚蠢的办法，耗时 3ms， 思路比较简单
    public static String MY_addBinary(String a, String b) {
        StringBuffer c = new StringBuffer();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        for ( ; i >= 0 && j >= 0; i --, j -- ) {
            int temp = (a.charAt(i)  - '0') + (b.charAt(j) - '0') + carry;
            carry = temp / 2;
            int num = temp % 2;
            c.append(num);
        }
        if (i < 0 && j < 0) {
            if ( carry == 1)
                c.append(carry);
        } else if (i < 0) {  // a比较长
            for (int k = j; k >= 0; k--) {
                int temp = (b.charAt(k) - '0') + carry;
                carry = temp / 2;
                int num = temp % 2;
                c.append(num);
            }
            if ( carry == 1)
                c.append(carry);
        } else {
            for (int t = i; t >= 0; t --) {
                int temp = (a.charAt(t) - '0') + carry;
                carry = temp / 2;
                int num = temp % 2;
                c.append(num);
            }
            if ( carry == 1)
                c.append(carry);
        }
        return c.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        StringBuffer c = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;   // 当前位的值
        while ( i >= 0 || j >= 0) {
            carry /= 2;  //表示上一位的进位
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i --;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j --;
            }
            c.append((carry > 1 ? carry - 2 : carry));
        }
        if (carry > 1)
            c.append(1);
        return c.reverse().toString();
    }

    public static void main(String [] args) {
        String a = "1", b = "111";
        String res = addBinary(a, b);
        System.out.println("res:" + res);
    }
}
