package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: 2019-07-04
 * Author: snowy
 * Leetcode 131: Palindrome Partitioning
 * */

public class PalindromePartitioning_131 {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        backTrack(s, 0, res, new ArrayList<>());

        return res;
    }

    public static void backTrack(String s, int index, List<List<String>> res, List<String> path) {
        if(path.size() > 0 && index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i ++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));

                backTrack(s, i + 1, res, path);

                path.remove(path.size() - 1);
            }
        }

    }

    public static boolean isPalindrome(String s, int left, int right) {
        if(left == right)
            return true;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }

        return true;
    }

    public static void main(String[] args) {
        String s= "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }
}
