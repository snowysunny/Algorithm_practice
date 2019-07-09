package leetcode.dynamic.com;

public class IsSubsequence_392 {

    public static boolean IsSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length())
            return false;

        int start = -1;
        for(int i = 0; i < s.length(); i  ++) {
            start ++;
            while(start < t.length()) {
                if(s.charAt(i) == t.charAt(start)) {
                    break;
                }
                start ++;
            }
            if(start == t.length())
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        boolean res = IsSubsequence(s, t);
        System.out.println(res);
    }
}
