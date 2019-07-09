package leetcode.string.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Time: 2019-06-12
 * Author: snowy
 * Leetcode 76: Minimum Window Substring
 * */

public class MinimumWindowSubstring_76 {
    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() < 1)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, head = 0;          // left： 左指针， right： 右指针，  head：开始的地方
        int count = 0;                              // 记录当前包含t中的字符的个数
        int minLength = s.length() + 1;             // 子串的最小长度

        for(int i = 0; i < t.length(); i ++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(; right < s.length(); right ++) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0)
                    count ++;
            }
//            System.out.println(count);

            while(count == t.length()) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    head = left;            // 记录开始的地方
                }

                if(map.containsKey(s.charAt(left))) {                       // 如果包含了左边的字符，map中该字符的数量加上1，并且如果该字符构成t中的一个有效位置的话将count-1
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0)
                        count --;
                }

                left ++;
            }
        }

        return minLength > s.length() ? "" : s.substring(head, head + minLength);
    }

    public static void main(String[] args) {
        String s = "ABAACBAB";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}
