package leetcode.math.com;

/**
 * leetcode
 * */

public class AddBinary_67 {
    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0) {
            if(i >= 0) {
                carry += a.charAt(i) - '0';
                i --;
            }
            if(j >= 0) {
                carry += b.charAt(j) - '0';
                j --;
            }
            sb.append(carry%2);
            carry /= 2;
        }
        if(carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String res = addBinary(a, b);
        System.out.println(res);

    }
}
