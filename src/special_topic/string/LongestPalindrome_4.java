package special_topic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Time: 2019-07-22
 * Author: snowy
 * leetcode 409: Longest Palindrome
 * */

public class LongestPalindrome_4 {
    public static int longestPalindrome(String s) {
        if(s == null || s.length() < 1)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int res = 0;

        for(char key : map.keySet()) {
            res += map.get(key) % 2 == 0 ? map.get(key) : map.get(key) - 1;
        }

        return res == s.length() ? res : res + 1;
    }

    public static void main(String[] arga) {
        String s = "abccccdd";
        int res = longestPalindrome(s);
        System.out.println(res);
        
    }
}
