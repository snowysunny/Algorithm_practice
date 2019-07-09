package office;

/**
 * Time: 2019-04-11
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * */

public class Array_FindNumsAppearOnce {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 1)
            return;
        int bits = 0;

        for(int i = 0; i < array.length; i ++)
            bits = bits ^ array[i];

        int bitsrightfirst1 = findFirstbitis1(bits);

        num1[0] = 0;
        num2[0] = 0;

        for(int i = 0; i < array.length; i ++) {
           // 这里注意比较的下标是Integer.toBinaryString(array[i]).length() - bitsrightfirst1
            if(Integer.toBinaryString(array[i]).length() >= bitsrightfirst1 && Integer.toBinaryString(array[i]).charAt(Integer.toBinaryString(array[i]).length() - bitsrightfirst1) == '1') {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }

    }

    // 从右向左寻找第一位不为0的位置
    public static int findFirstbitis1(int num) {
        int index = -1;
        for(int i = Integer.toBinaryString(num).length() - 1; i >= 0; i --) {
            if (Integer.toBinaryString(num).charAt(i) != '0') {
                index = i;
                break;
            }
        }
        return Integer.toBinaryString(num).length() - index;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int num1[] = {0};
        int num2[] = {0};
        FindNumsAppearOnce(array, num1 , num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
