package office;

import java.util.Arrays;

/**
 * Time: 2019-04-10
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * */


public class Array_InversePairs {
    /**
     * 借助于归并排序的思想，从后向前进行排序
     * */


    public static int InversePairs(int [] array) {
        if(array == null || array.length < 1)
            return 0;

        int[] copy = new int[array.length];

        int res = MergeInversePairs(array, copy, 0, array.length - 1);

        return res;
    }

    /**
     * @param array
     * @param copy  用来存储排好序的结果
     */
    public static int MergeInversePairs(int[] array, int[] copy, int start, int end) {
        int res = 0;

        if(array == null || array.length <1 || start >= end)
            return 0;

        int mid = (start + end) >> 1;
        int leftCount = MergeInversePairs(array, copy, start, mid)%1000000007;
        int rightCount = MergeInversePairs(array, copy,mid+1, end) %1000000007;

        int left = mid, right = end;
        int rightcopy = end;

        while(left >= start && right > mid) {
            if(array[left] <= array[right]) {
                copy[rightcopy --] = array[right --];
            } else {
                copy[rightcopy --] = array[left --];
                res = (res + right - mid) %1000000007;    // 逆序对计数
            }
        }

        if (left >= start) {
            for (int i = left; i >= start; i --)
                copy[rightcopy --] = array[i];
        }
        if (right > mid) {
            for(int i = right; i > mid; i --) {
                copy[rightcopy --] = array[i];
//                res = (res + i - mid) %1000000007;
            }
        }

//        将排好序的赋值给原数组，参与到下一次的逆序计算
        for(int i = start; i <= end; i ++)
            array[i] = copy[i];

        return res + leftCount + rightCount;
    }



    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        int res = InversePairs(array);
        System.out.println(Arrays.toString(array));
        System.out.println(res);
    }
}
