package office;

/**
 * Time: 2019-03-26
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */

import java.lang.Math;

public class RectCover {

    // 与跳台阶的是一样的

    public int RectCover (int target) {
        if (target <= 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return RectCover(target - 1) + RectCover(target - 2);
    }

    public int RectCover_iter(int target) {
        int a = 1, b = 1, c = 1;
        if (target <= 0)
            return 0;

        for (int i = 2; i <= target; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        RectCover rc = new RectCover();
        int res = rc.RectCover_iter(7);
        System.out.println(res);
    }
}
