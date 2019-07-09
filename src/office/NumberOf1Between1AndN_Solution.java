package office;


/**
 * Time: 2019-04-08
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * */

public class NumberOf1Between1AndN_Solution {
    /**
     * 分析：   1-9：       1
     *          1-99：       20
     *          1-999：      300
     *          1-9999：     4000 = 1000 * 4 = 1000 + 300 * 10
     *          1-99999：    50000 = 10000* 5 = 10000 + 4000 * 10
     *
     *
     *  以21345为例： =>   1 - 20000  与 20001 - 21345， 其中 1 - 20000中：10000 + 1000 * 4（数的位数-1） * 2 （数的第一位） = 18000
     *                  20001 - 21345  =>  1000 - 1345  和 1- 999 （300个）
     *                  1000-1345又分为千位为1 和千位不为1， 千位为1时其他为不考虑会有 346个
     *
     *                  1-300：   100 + 20*3=160
     *                  1-45：    10 + 1 * 4 = 14
     *                  1-5：      1
     *
     *
     *                  找规律
     *
     * */
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1)
            return 0;

        if (n < 10)
            return 1;

        int res = 0;

        int bits = getBits(n);

        int mod = n % (int)Math.pow(10, bits - 1);
        int div = n / (int)Math.pow(10, bits - 1);

        if(div == 1)        // 首位为1的情况
            res = mod + 1 + (int)Math.pow(10, bits - 2) * (bits - 1);
        else                // 首位不为1的情况
            res = (int)Math.pow(10, bits - 1) + (int)Math.pow(10, bits - 2) * (bits-1) * div;

        System.out.println(n +  ":  " + res);
        return res + NumberOf1Between1AndN_Solution(mod);
    }

//    获取数n是多少位的数据
    public static int getBits(int n) {
        if(n < 1)
            return 0;

        int bits = 0;
        while(n > 0) {
            n = n / 10;
            bits ++;
        }

        return bits;
    }

    public static void main(String[] args) {
        int n = 9999;
        int res = NumberOf1Between1AndN_Solution(n);
        System.out.println(res);
        int bits = getBits(n);
        System.out.println(bits);
    }
}
