package leetcode.dynamic.com;

/**
 * Time: 2019-06-21
 * Author: snowy
 * Leetcode 978: Longest Turbulent Subarray
 * 求过山车数组吧
 * */

public class LongestTurbulentSubarray_978 {
    public static int maxTurbulenceSize(int[] A) {
        if(A == null || A.length < 1)
            return 0;

        int max = 1;
        int dec = 1, inc = 1;
        for(int i = 1; i < A.length; i ++) {
            if(A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else if(A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                dec = 1;
                inc = 1;
            }
            max = Math.max(max, Math.max(dec, inc));
        }
//        int[] array1 = new int[A.length];
//        int[] array2 = new int[A.length];
//
//        array1[0] = array2[0] = 1;
//
//        for(int i = 1; i < A.length; i ++ ) {
//            if(i % 2 == 0) {
//                if(A[i] == A[i - 1]) {
//                    array1[i] = array2[i] = 1;
//                } else if(A[i] > A[i - 1]) {
//                    array1[i] = 1;
//                    array2[i] = array2[i - 1] + 1;
//                } else {
//                    array1[i] = array1[i - 1] + 1;
//                    array2[i] = 1;
//                }
//            } else {
//                if(A[i] == A[i - 1]) {
//                    array1[i] = array2[i] = 1;
//                } else if(A[i] > A[i - 1]) {
//                    array1[i] = array1[i - 1] + 1;
//                    array2[i] = 1;
//                } else {
//                    array1[i] = 1;
//                    array2[i] = array2[i - 1] + 1;
//                }
//            }
//
//            max = Math.max(max, Math.max(array1[i], array2[i]));
//        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {9,4,2,10,7,8,8,1,9};
        int res = maxTurbulenceSize(A);
        System.out.println(res);
    }
}
