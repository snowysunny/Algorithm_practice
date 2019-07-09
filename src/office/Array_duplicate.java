package office;

import java.util.Arrays;

/**
 * Time: 2019-04-16
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * */

public class Array_duplicate {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length < 1)
            return false;

        for(int i = 0; i < length; i ++) {
            int index = numbers[i] % length;
            numbers[index] += length;
        }
        for (int i = 0; i < length; i ++) {
            if(numbers[i] >= 2 * length) {
                duplication[0] = i;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 3, 2, 7, 0, 2, 3, 1};
        int length = numbers.length;
        int[] duplication = new int[length];
        boolean res = duplicate(numbers, length, duplication);
        System.out.println(Arrays.toString(numbers));
        System.out.println(res);
    }
}
