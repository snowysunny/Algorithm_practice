package office;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Time: 2019-04-09
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 参考： leetcode 179. Largest Number 、 剑指offer T33
 * */


public class Sort_PrintMinNumber {
    public static String PrintMinNumber(int[] numbers) {
        if(numbers == null || numbers.length < 1)
            return "";

        String[] numStr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i ++) {
            numStr[i] = String.valueOf(numbers[i]);
        }

        // 特殊的排序，两两进行组合较小的那个数，使用的是字符串的排序
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo((o2 + o1));
            }
        });

        String res = "";
        for(String str : numStr)
            res += str;

        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        String res = PrintMinNumber(numbers);
        System.out.println(res);
    }
}
