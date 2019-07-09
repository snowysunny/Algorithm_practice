package leetcode.string.com;

import java.util.Arrays;
import java.util.Collections;

/**
 * Time: 2019-04-24
 * Author: snowy
 * leetcode 5: 最长回文子串
 * */

public class LongestPalindromicString_5 {
    /**
     * 马拉车算法
     * 时间复杂度为: O(n)
     * 这个是有博客的：
     * */
    public static String  longestPalindromicString(String originString) {
        StringBuffer modifyString = new StringBuffer();
        modifyString.append("#");

        // 首先处理一下字符串，将字符串的长度处理成奇数，这样就不用单独考虑字符串长度的奇偶了
        for(int i = 0; i < originString.length(); i ++) {
            modifyString.append(originString.charAt(i));
            modifyString.append("#");
        }

        // 记录回文中心
        int curCenter = 0;

        // 记录右边界
        int rightCover = 0;
        // 记录右边界的回文中心
        int rightCenter = 0;
        // 保存每个字符为中心的回文长度的一半
        int[] halfLength = new int[modifyString.length()];

        // 记录最长的回文长度
         int longestHalf = 0;

         for(int i = 0; i < modifyString.length(); i ++) {
             // 中心扩展
             boolean needCalc = true;

             if(rightCover > i) {
//                 计算以rightCenter为中心的i对称的位置
                 int leftCenter = 2 * rightCenter - i;
//                 根据回文性质
//                 超出右边界需要进行调整
                 if(halfLength[leftCenter] + i >= rightCover) {
                     halfLength[i] = rightCover - i;
                 }else {                            // 如果不大于右边界，则不需要进行中心扩展
                    halfLength[i] = halfLength[leftCenter];
                     needCalc = false;
                 }
             }

             // 中心扩展
             if(needCalc) {
                 while(i - 1 - halfLength[i] >= 0 && i + 1 + halfLength[i] < modifyString.length() && modifyString.charAt(i - 1 - halfLength[i]) == modifyString.charAt(i + 1 + halfLength[i])) {
                     halfLength[i] ++;
                 }

                 // 更新和扩展右边界
                 rightCover = i + halfLength[i];
                 rightCenter = i;

                 // 记录最长的回文长的中心和一半长度
                 if(halfLength[i] > longestHalf) {
                     curCenter = i;
                     longestHalf = halfLength[i];
                 }
             }

         }

        StringBuffer res = new StringBuffer();
        for(int i = curCenter - longestHalf + 1; i < curCenter + longestHalf; i += 2)
            res.append(modifyString.charAt(i));

        return res.toString();
    }


    public static boolean isPalindromic(String originString) {
        if (originString.length() < 1 || originString == null)
            return false;

        int left = 0, right = originString.length() - 1;
        while(left < right) {
            if(originString.charAt(left) != originString.charAt(right))
                return false;

            left ++;
            right --;
        }

        return true;
    }



    public static void main(String[] args) {
        String originString = "abcdefedcbaa";

//        boolean isPalindromic = isPalindromic(originString);
//        System.out.println(isPalindromic);

        String res = longestPalindromicString(originString);
        System.out.println(res);
    }
}
