package office;

import java.util.Arrays;

/**
 * Time: 2019-04-16
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * */

public class Array_multiply {
    public static int[] multipy(int[] A) {
        int[] res = new int[A.length];
        if(A == null || A.length < 1)
            return res;

        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 1;
        right[A.length - 1] = 1;

        for (int i = 1; i < A.length; i ++) {
            left[i] = left[i - 1] * A[i - 1];
            right[A.length - i - 1] = right[A.length - i] * A[A.length - i];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < A.length; i ++)
            res[i] = left[i] * right[i];

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] res = multipy(A);
        System.out.println(Arrays.toString(res));
    }
}
