package office;

/**
 * Time: 2019-03-25
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * */

public class JumpFloor {
    // 非递归版本
    public int JumpFloor(int target) {
        if (target <= 0)
            return 0;

        int a = 1, b = 1, c = 1;

        for(int i = 2; i <= target; i ++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public int JumpFloor_recursion(int target) {
        if (target <= 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return JumpFloor_recursion(target - 1) + JumpFloor_recursion(target - 2);
    }

    public static void main(String[] args) {
        JumpFloor jf = new JumpFloor();

        int res = jf.JumpFloor(10);
        System.out.println(res);

        int ans = jf.JumpFloor_recursion(10);
        System.out.println(ans);
    }
}
