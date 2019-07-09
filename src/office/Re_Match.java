package office;

/**
 * Time: 2019-04-17
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * */

public class Re_Match {
    public static boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null)
            return false;
        return matchCore(str, pattern, 0, 0);
    }

    public static boolean matchCore(char[] str, char[] pattern, int start1, int start2) {
        if(start1 == str.length && start2 == pattern.length)
            return true;

        if (start1 != str.length && start2 == pattern.length) {
            return false;
        }

        if(start2 + 1 < pattern.length && pattern[start2 + 1] == '*') {

            if( (start1 != str.length && str[start1] == pattern[start2])
                    || (pattern[start2] == '.' && start1 != str.length)) {
                return matchCore(str, pattern, start1+1, start2 + 2)
                        || matchCore(str, pattern, start1 + 1, start2)
                        || matchCore(str, pattern, start1, start2 + 2);
            } else
                return matchCore(str, pattern, start1, start2 + 2);
        }

        if((start1 != str.length && str[start1] == pattern[start2])
                || (start1 != str.length &&pattern[start2] == '.'))
            return matchCore(str, pattern, start1 + 1, start2 + 1);


        return false;
    }



    public static void main(String[] args) {
        char[] str = {'a'};
        char[] pattern = {'.', '*', '.', '.', 'a', '*'};
        boolean res = match(str, pattern);
        System.out.println(res);
    }
}
