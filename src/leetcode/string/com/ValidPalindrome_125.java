package leetcode.string.com;

public class ValidPalindrome_125 {
    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;

        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");

        System.out.println(s);

        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s =  "0P";

        boolean res = isPalindrome(s);
        System.out.println(res);
    }
}
