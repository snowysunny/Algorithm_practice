package special_topic.sort.basic;

/**
 * 冒泡排序
 * Function: 正常的冒泡排序是先将最大的数据归好位置，然后是次大，以此类推，最后将整个数列排列好
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢浮到数列的顶端
 * ######算法描述######
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数
 * 针对所有的元素重复以上的步骤，除了最后一个
 * 重复步骤1-3，直到排序完成
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmYTANnYjhiaAU3RyxWw2WyWaicgZmfuyYP1s5iaUQaJh3ShGog3XliceqTw/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(n^2)， 最坏 O(n^2)， 最好O(n)，  空间复杂度O(1)， 是稳定的
 * */


import java.util.Arrays;
import java.util.List;

import static special_topic.sort.basic.Swap.swapTwoNumber;

public class BubbleSort {

    // 冒泡排序
    public static List<Integer> BubbleSort(List<Integer> bubbleArr) {
        for(int i = 0; i < bubbleArr.size() - 1; i ++) {        // 外层循环，用于判断
            for(int j = 1; j < bubbleArr.size() - i ; j ++) {
                if(bubbleArr.get(j) < bubbleArr.get(j - 1)) {
                    swapTwoNumber(bubbleArr, j, j - 1);		// 交换两数
                }
            }
        }

        return bubbleArr;
    }

    // 带有哨兵的冒泡排序
    public static List<Integer> BubbleSort_EalyStop_v(List<Integer> bubbleArr) {
        for(int i = 0; i < bubbleArr.size() - 1; i ++) {
            boolean flag = true;        // 用于标记，记录该数组是否已经为有序序列
            // j的最大值为arr.size() - 1 - i， 减去i是因为大的数据已经在对应的位置上了
            for (int j = 0; j < bubbleArr.size() - 1 - i; j++) {
                if(bubbleArr.get(j) > bubbleArr.get(j + 1)) {       // 相邻两个数进行比较，如果顺序错位则进行替换
                    flag = false;
                    swapTwoNumber(bubbleArr, j, j + 1);
                }
            }
            if (flag)           // 该数列已经为有序序列了
                break;
        }
        return bubbleArr;
    }

    // 测试
    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> bubbleArr = Arrays.asList(source);               // 将数据替换成List的方式

        // 冒泡排序
        System.out.println("冒泡排序前： " + bubbleArr);
        List<Integer> bubbleRes = BubbleSort_EalyStop_v(bubbleArr);
        System.out.println("冒泡排序的结果为： " + bubbleRes);
    }
}