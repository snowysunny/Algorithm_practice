package office;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Time: 2019-04-07
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * */

public class String_Permutation {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();

        if(str == null || str.length() <= 0)
            return res;

        char[] chars = str.toCharArray();
        Permutation_help(chars, res, 0);
        Collections.sort(res);
        return res;
    }

    public static void Permutation_help(char[] str, ArrayList<String> res, int start) {
        if(start >= str.length - 1) {
            if(!res.contains(new String(str))) {
                res.add(new String(str));
            }
        } else {
            for(int i = start; i < str.length; i ++) {
                // 将开始的字符分别与后面的字符进行交换
                swap(str, start, i);
                Permutation_help(str, res, start + 1);
                // 还原成原先的字符
                swap(str, i, start);
            }
        }
    }

    // 两数交换
    public static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        String test = "abc";
        ArrayList<String> res = Permutation(test);

        System.out.println(res);
    }
}
