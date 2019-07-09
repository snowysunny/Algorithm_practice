package leetcode.dynamic.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: 2019-07-08
 * Author: snowy
 * Leetcode 140: Word Break II
 * */

public class WordBreak_II_140 {

    // 深度优先搜索的解法，但是这种是通不过去的
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(s, wordDict, 0, res, new ArrayList<>());
        return res;
    }

    public static void dfs(String s, List<String> wordDict, int start, List<String> res, List<String> path) {
        if(s.length() == start) {
            String cur = "";
            for(String ss : path) {
                cur += ss + " ";
            }
            res.add(cur.substring(0, cur.length() - 1));
            return;
        }

        for(int i = start; i < s.length(); i ++) {
            if(wordDict.contains(s.substring(start, i + 1))) {
                path.add(s.substring(start, i + 1));
                dfs(s, wordDict, i + 1, res, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] words = {"cat", "cats", "and", "sand", "dog"};
        List<String> list = Arrays.asList(words);
        List<String> res = wordBreak(s, list);
        System.out.println(res);
    }
}
