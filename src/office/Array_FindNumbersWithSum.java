package office;

import java.util.ArrayList;

/**
 * Time: 2019-04-12
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * */

public class Array_FindNumbersWithSum {
    /**
     * 双向指针
     * */

    public static ArrayList<Integer> Array_FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 0)
            return res;

        int left = 0, right = array.length - 1;

        while(left < right) {
            int count = array[left] + array[right];
            if(count == sum) {
                res.add(array[left]);
                res.add(array[right]);
                break;
            } else if(count > sum)
                right --;
            else
                left ++;

        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 11, 15};
        ArrayList<Integer> res = Array_FindNumbersWithSum(array, 15);
        System.out.println(res);
    }
}
