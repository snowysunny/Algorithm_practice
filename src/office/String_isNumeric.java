package office;
/**
 * Time: 2019-04-12
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=3&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * */
public class String_isNumeric {
    public static boolean isNumeric(char[] str) {
        if(str == null || str.length < 1)
            return false;

        int signflag = 0, dotflag = 0, eflag = 0;

        int i = 0;
        for(;i < str.length; i ++) {
            if(str[i] == '+' || str[i] == '-'){
                if(i == 0 || (i - 1 > 0 && (str[i - 1] == 'e' || str[i - 1] == 'E')) )
                    signflag = 1;
                else
                    return false;
            }else if(str[i] >= '0' && str[i] <= '9') {
                signflag = 0;
            }else if(str[i] == '.') {
                if(eflag != 0 || dotflag != 0)
                    return false;
                else
                    dotflag = 1;
            }else if(str[i] == 'e' || str[i] == 'E') {
                if(eflag != 0)
                    return false;
                else
                    eflag = 1;
            }else {
                return false;
            }
        }
        if(str[i - 1] >= '0' && str[i - 1] <= '9')
            return true;
        return false;
//        String s=String.valueOf(str);
//        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    public static void main(String[] args) {
        String strs = "+.E";
        char[] str = strs.toCharArray(); //{'+', '1', '0', '0'};
        boolean res = isNumeric(str);
        System.out.println(res);
    }
}
