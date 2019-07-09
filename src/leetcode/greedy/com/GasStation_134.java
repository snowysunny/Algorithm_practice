package leetcode.greedy.com;

/**
 * Time: 2019-06-02
 * Author: snowy
 * Leetcode 134: Gas Station
 * */

public class GasStation_134 {
    // 暴力法
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int remain = 0;
        for(int i = 0; i < length; i ++) {
            remain = 0;
            int j = 0;
            for(; j < length; j ++) {
                remain += gas[(i + j)  % length] - cost[(i + j) % length];      // 先判断当前加的油可以到达下一个结点
                if(remain < 0) {
                    break;
                }
            }
            if(remain >= 0 && j == length)
                return i;
        }

        return -1;
    }

    // 贪心法，看看那个点上能够使得收入大于支出，当指出大于收入时，向后移动一个位置
    public static int canCompleteCircuit_greedy(int[] gas, int[] cost) {
        int sumGas = 0;     // 总的能量
        int sumCost = 0;    // 总消耗
        int tank = 0;       // 当前剩余的容量

        int idx = 0;

        for(int i = 0; i < gas.length; i ++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0) {
                idx = i + 1;
                tank = 0;
            }
        }

        return sumGas >= sumCost ? idx : -1;
    }


    public static void main(String[] args) {
        int[] gas = {3, 3, 4};
        int[] cost = {3, 4, 4};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
