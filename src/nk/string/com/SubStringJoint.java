package nk.string.com;

import java.util.Scanner;

/**
 * Time: 2019-01-24     Author: snowy
 * 招商银行信用卡中心秋招： 字符串是否由子串拼接
 * 链接：https://www.nowcoder.com/questionTerminal/6e3ff5d892c342ae8f367355b66bab55
 * 来源：牛客网
 *
 * 【题目描述】 给出一个非空的字符串，判断这个字符串是否是由它的一个子串进行多次首尾拼接构成的。
 *              例如，"abcabcabc"满足条件，因为它是由"abc"首尾拼接而成的，而"abcab"则不满足条件。
 *
 * 输入描述: 非空字符串
 * 输出描述: 如果字符串满足上述条件，则输出最长的满足条件的的子串；如果不满足条件，则输出false。
 * */

public class SubStringJoint {
    public static void subStringJoint(String src_string){
        int res_len = src_string.length() - 1;
        for (int i = 0; res_len > 0; res_len --) {          // 子串的长度，因为要求最大拼接子串，从大到小进行递减
            if (src_string.length() % res_len == 0) {       // 如果是拼接子串的话，那么拼接子串长度肯定能够整除整个字符串
                for (i = 0; i < src_string.length() && src_string.charAt(i) == src_string.charAt(i % res_len); i ++) {}         // 子串比较

                if (i == src_string.length())
                    break;
            }
        }
        System.out.println(res_len != 0 ? src_string.substring(0, res_len) : "false");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String src_string = input.next();
            subStringJoint(src_string);
        }
    }
}
