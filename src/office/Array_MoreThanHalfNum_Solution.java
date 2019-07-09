package office;

/**
 * Time: 2019-04-07
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * */

public class Array_MoreThanHalfNum_Solution {

    // Solution: 维持两个变量，一个用于记录数组中的数字，一个用于记录该数字出现的次数，当下一个数字与保留的数字一样时，次数+1，不一样时，次数-1，当次数为0时，将记录的数字替换掉

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0)
            return 0;

        int num = array[0], count = 1;

        for(int i = 1; i < array.length; i ++) {
            if(count == 0) {
                num = array[i];
                count = 1;
            } else {
                if(num == array[i]) {
                    count ++;
                } else {
                    count --;
                }
            }
        }
        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == num)
                count ++;
        }
        return count > array.length / 2 ? num:0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,2,4};
        int res = MoreThanHalfNum_Solution(array);
        System.out.println(res);
    }
}
