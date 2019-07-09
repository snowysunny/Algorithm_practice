package office;

import java.util.Arrays;

/**
 * Time: 2019-04-09
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * */


public class GetUglyNumber_Solution {
    public static int GetUglyNumber_Solution(int index) {
        if(index < 1)
            return 0;

        int[] res = new int[index];
        res[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;         // 分别用于记录2， 3， 5当前做乘法的基数

        for(int i = 1; i < index; i ++) {
            int temp = Math.min(res[index2] * 2, Math.min(res[index3] * 3, res[index5] * 5));
            if(temp == res[index2] * 2)
                index2 ++;
            if(temp == res[index3] * 3)
                index3 ++;
            if(temp == res[index5] * 5)
                index5 ++;

            res[i] = temp;
        }

        System.out.println(Arrays.toString(res));

        return res[index - 1];
    }

    public static void main(String[] args) {
        int index = 20;
        int res = GetUglyNumber_Solution(index);
        System.out.println(res);
    }
}
