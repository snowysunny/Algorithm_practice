package leetcode.string.com;

/**
 * Time: 2019-05-15
 * Author: snowy
 * Leetcode 38: Count and Say
 * */

public class CountandSay_38 {
    public static String countAndSay(int n) {
        if( n== 1)
            return "1";

        String res = "1";

        for(int i = 1; i < n; i ++) {
            String temp = "";
            int count = 0;
            char c = res.charAt(0);
            for(int j = 0; j < res.length(); j ++) {
                if(res.charAt(j) == c) {
                    count ++;
                } else {
                    temp = temp + count + c;
                    c = res.charAt(j);
                    count = 1;
                }
            }
            temp = temp + count + c;
            res = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        String res = countAndSay(n);
        System.out.println(res);
    }
}
