package leetcode.string.com;

public class FirstUniqueCharacterinaString_387 {
    public static int firstUniqChar(String s) {
        char[] character = new char[26];

        for(char c : s.toCharArray())
            character[c - 'a'] ++;

        for(int i = 0; i < s.length(); i ++)
            if(character[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }


    public static int firstUniqChar_2(String s) {
        int min = s.length();

        for(char c = 'a'; c <= 'z'; c ++) {
            int first = s.indexOf(c);
            if(first == -1)
                continue;
            int last = s.lastIndexOf(c);
            if(first == last)
                min = Math.min(min, first);
        }
        return min == s.length() ? -1 : min;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        int res = firstUniqChar(s);
        System.out.println(res);
    }
}
