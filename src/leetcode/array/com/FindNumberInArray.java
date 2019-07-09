package leetcode.array.com;

/**
 * Time: 2019-06-25
 * Author: snoey
 * 这道题比较有意思，有这样一个数组A，大小为n，相邻元素差的绝对值都是1。如A={4, 5, 6, 5, 6, 7, 8, 9, 10, 9}，现在给定A和目标整数t，请找到t在A中的位置。不能使用依次遍历实现
 *
 * 解题思路： 数组第一个数为array[0]，要找的数为y，设t=abs(y-array[0])。由于每个相邻的数字之差的绝对值为1.故第t个位置之前的数肯定都比y小。因此直接定位到array[t]，重新计算t， t = abs(y-array[t])，在重复上述步骤即可
 * 这种算法主要利用了当前位置的数与查找数的差来实现跨越式搜索。算法效率要比遍历数组的算法要高一些，并且易于实现
 * */

public class FindNumberInArray {
    public static int findNumberinArray(int[] array, int target) {
        if(array == null || array.length < 1)
            return -1;
        int index = Math.abs(target - array[0]);
        while(index < array.length) {
            if(array[index] == target)
                return index;

            index += target - array[index];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 5, 6, 7, 8, 9, 10, 9};
        int target = 10;
        int res = findNumberinArray(A, target);
        System.out.println(res);
    }
}
