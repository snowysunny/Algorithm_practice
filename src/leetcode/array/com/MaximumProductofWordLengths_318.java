package leetcode.array.com;

import java.util.*;

public class MaximumProductofWordLengths_318 {

    public static int maxProduct(String[] words) {
        if(words == null || words.length < 2)
            return 0;

        int[] map = new int[words.length];          // 将每个字符串进行二进制编码，记录每个字符串上存在的字符

        for(int i = 0; i < words.length; i ++) {
            int num = 0;
            for(int j = 0; j < words[i].length(); j ++) {
                num |= 1 << (words[i].charAt(j) - 'a');         // 将每一位使用二进制进行编码
            }
            map[i] = num;
        }

        int max = 0;
        for(int i = 0; i < words.length - 1; i ++) {
            for(int j = i + 1; j < words.length; j ++) {
                if((map[i]&map[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int res = maxProduct(words);
        System.out.println(res);
    }
}
