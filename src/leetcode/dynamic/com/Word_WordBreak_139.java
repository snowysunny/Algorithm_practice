package leetcode.dynamic.com;

import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-06-04
 * Author: snowy
 * Leetcode 139: Word Break
 * */

public class Word_WordBreak_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] wordStart = new boolean[s.length() + 1];          // 记录开始的位置
        wordStart[0] = true;

        for(int i = 1; i <= s.length(); i ++) {
            for(int j = i - 1; j >= 0; j --) {
                if(wordStart[j] && wordDict.contains(s.substring(j, i))) {
                    wordStart[i] = true;
                    break;
                }
            }
        }
        return wordStart[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] words = {"leet", "code"};
        List<String> wordDict = Arrays.asList(words);
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }
}
