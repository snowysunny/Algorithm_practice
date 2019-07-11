package special_topic.string;

import java.util.Arrays;

public class KMP {
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() < 1)
            return 0;
        int[] next = getNext(needle);
        int index1 = 0, index2 = 0;
        while(index1 < haystack.length() && index2 < needle.length()) {
            if(index2 == -1 || haystack.charAt(index1) == needle.charAt(index2)) {          //  如果相等，指针都向后移动， 或者如果指针指向p字符串的头部则将haystack指针向后移动
                index1 ++;
                index2 ++;
            } else {
                index2 = next[index2];
            }
        }

        if(index2 == needle.length())
            return index1 - needle.length();

        return -1;
    }

    public static int[] getNext(String needle) {
        if(needle.length() < 1 || needle == "")
            return null;
        int[] next = new int[needle.length()];
        next[0] = -1;

        int i = 0, j = -1;

        while(i < needle.length() - 1) {
            if(j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle =  "ssi";

        int res = strStr(haystack, needle);
        System.out.println(res);
    }
}
