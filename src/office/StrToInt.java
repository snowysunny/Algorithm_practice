package office;

/**
 * Time: 2019-04-16
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * */

public class StrToInt {
    public static int StrToInt(String str)
    {
        if(str == null || str == "" || str.trim().equals("") || str.length() < 1)
            return 0;
        int num = 0;
        int sign = 1;
        if(str.charAt(0) == '-')
            sign = -1;

        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) == '+' || str.charAt(i) == '-') {
                if(num != 0)
                    return 0;
                else
                    continue;
            }
            if (str.charAt(i) < 48 || str.charAt(i) > 57)
                return 0;
            else
                num = num * 10 + str.charAt(i) - '0';

//            判断是否越界
            if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
                return 0;
        }

        return num * sign;
    }

    public static void main(String[] args) {
        String str = "90+12";
        int res = StrToInt(str);
        System.out.println(res);
    }
}
