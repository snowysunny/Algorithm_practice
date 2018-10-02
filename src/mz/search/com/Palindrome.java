package mz.search.com;

/**
 * Time: 2018-10-02    Author: Snowy
 * 寻找字符串中的最大回文子串
 * */

public class Palindrome {
    // 判断字符串是否为回文串
    public static boolean isPlalindrome_(String s) {
        int s_len = s.length();
        if (s_len <= 0) {
            return false;
        }
        if (s_len == 1) {
            return true;
        }
        int left, right = 0;
        if (s_len % 2 == 0) {
            right = s_len / 2;
            left = right - 1;
        } else {
            left = s_len / 2 - 1;
            right = s_len / 2 + 1;
        }
        while (left >= 0 && right < s_len) {
//            System.out.println("left: " + left + ", right: " + right + ", " + s.charAt(left) + ", " + s.charAt(right));
            if (s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            } else {
                return false;
            }
        }
        return true;
    }

    // 判断一个字符串是否回文，算法中用不到了
    public static boolean isPlalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i ++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // 预处理字符串，在字符间添加特殊符号'#'
    private static String preHandleString(String s) {
        StringBuffer sb = new StringBuffer();
        int s_len = s.length();
        sb.append("#");
        for (int i = 0; i < s_len; i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    // 寻找最长回文字串
    public String findLongestPlalindromeString(String s) {
        // 先预处理字符串
        String str = preHandleString(s);
        // 处理后的字串长度
        int len = str.length();
        // 右边界
        int rightSide = 0;
        // 右边界对应的回文串中心
        int rightSideCenter = 0;
        // 保存以每个字符为中心的回文长度一半（向下取整）
        int[] halfLenArr = new int[len];
        // 记录回文中心
        int center = 0;
        // 记录最长回文长度
        int longestHalf = 0;
        for(int i = 0; i < len; i++) {
            // 是否需要中心扩展
            boolean needCalc = true;
            // 如果在右边界的覆盖之内
            if(rightSide > i) {
                // 计算相对rightSideCenter的对称位置
                int leftCenter = 2 * rightSideCenter - i;
                // 根据回文性质得到的结论
                halfLenArr[i] = halfLenArr[leftCenter];
                // 如果超过了右边界，进行调整
                if(i + halfLenArr[i] >= rightSide) {
                    halfLenArr[i] = rightSide - i;
                }
                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                if(i + halfLenArr[leftCenter] < rightSide) {
                    // 直接推出结论
                    needCalc = false;
                }
            }
            // 中心扩展
            if(needCalc) {
                while(i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
                    if(str.charAt(i + 1 + halfLenArr[i]) == str.charAt(i - 1 - halfLenArr[i])) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + halfLenArr[i];
                rightSideCenter = i;
                // 记录最长回文串
                if(halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }
            }
        }
        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for(int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String findLongestPlalindromeSubstring(String s) {

        String new_str = preHandleString(s);        // 首先处理一下字符串，在字符之间添加“#”

        int new_str_len = new_str.length();         // 处理后的字符串的长度

        int longestHalf = 0;                        // 记录下最长回文长度

        int [] halfLenArr = new int[new_str_len];   // 每个位置上字符的回文长度

        int rightSide = 0;                          // 最右边的边界下标

        int rightCenter = 0;                    // 记录最右边的回文串的中心

        int center = 0;                        // 记录最长的回文子串的中心

        for (int i = 0; i < new_str_len; i ++) {
            boolean outSide = true;         // 超出右边界，进行更新扩展

            if (i < rightSide) {
                // 当前i以rightCenter为中心对称的位置
                int leftCenter =  2 * rightCenter - i;    //rightCenter - (i - rightCenter);

                if (i + halfLenArr[leftCenter] >= rightSide) {   // // 如果超过了右边界，进行调整
                    halfLenArr[i] = rightSide - i;
                } else {            // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                    // 根据回文性质得到的结论
                    halfLenArr[i] = halfLenArr[leftCenter];
                    outSide = false;
                }

            }
            // 超出右边界，进行中心扩展
            if (outSide) {
                while (i - 1 - halfLenArr[i] >= 0 && (i + 1 + halfLenArr[i] < new_str_len)  ) {
                    if (new_str.charAt(i - 1 - halfLenArr[i]) == new_str.charAt(i + 1 + halfLenArr[i])) {
                        halfLenArr[i] ++;
                    } else {
                        break;
                    }
                }
                // 更新右边界和中心
                rightCenter = i;
                rightSide = i + halfLenArr[i];
                if (halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }

            }
        }

        StringBuffer palindromeSubstring = new StringBuffer();
        for (int j = center - longestHalf + 1; j < center + longestHalf; j += 2) {
            palindromeSubstring.append(new_str.charAt(j));
        }

        return palindromeSubstring.toString();
    }

    public static void main(String[] args) {
        Palindrome ps = new Palindrome();

        String []testPalinderomestr = new String[] {
                "abcdcef",
                "adaelele",
                "cabadabae",
                "aaaabcdefgfedcbaa",
                "aaba",
                "aaaaaaaaa"
        };

        for (String str : testPalinderomestr) {
            System.out.println(String.format("原字串 : %s", str));
            System.out.println(String.format("最长回文串 : %s", ps.findLongestPlalindromeSubstring(str)));
            System.out.println();
        }


    }
}
