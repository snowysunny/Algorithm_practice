package special_topic.sort.basic;

/**
 * Author: snowy        Time: 2019/3/31
 * 快速排序
 * Function: 快速排序是每次将选中的数送到该数对应的最终位置上
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有关
 * ######算法描述###### 快速排序使用分治法来把一个串(list)分成两个子串(sub-lists)。
 * 从数列中挑出一个元素，称为“基准”(pivot)
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区操作
 * 递归地把小于基准值元素的子序列和大于基准值元素的子序列排序
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmia2UqkZMibKlXzZ6OqEATKJ7iajmEc9zRiciav9Z05mP6P4ZqfJia0ia2djUw/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 *      * 时间复杂度： 平均 O(nlogn)， 最坏 O(n^2)， 最好O(nlogn)，  空间复杂度O(nlogn)， 是不稳定的
 * */

import java.util.Arrays;
import java.util.List;

import static special_topic.sort.basic.Swap.swapTwoNumber;

public class QuickSort {

    // 寻找分割的位置
    public static int partition_v1(List<Integer> quickArr, int left, int right) {
        int temp = quickArr.get(left);          // 基准数据

        while(left < right) {
            // 当队尾的元素大于等于基准数据时,向前挪动right指针
            while(quickArr.get(right) >= temp && left < right) {
                right --;
            }
            if(left < right)
                quickArr.set(left, quickArr.get(right));        // 如果队尾元素小于temp了,需要将其赋值给left的位置，因为当前这个位置left上可以认为值是无效的

            // 当队首元素小于等于temp时,向前挪动left指针
            while(quickArr.get(left) <= temp && left < right) {
                left ++;
            }
            if(left < right)
                quickArr.set(right, quickArr.get(left));        // 如果队尾元素小于temp了,需要将其赋值给left的位置，因为当前right这个位置上可以认为值是无效的
        }

        // 最后left和right是相等的，这个位置是用来安置temp的
        quickArr.set(left, temp);
        System.out.println(quickArr);
        return left;
    }

    // 寻找分割的位置2
    public static int partition_v2(List<Integer> quickArr, int left, int right) {
        int current = quickArr.get(left);

        int index = left;       // 用于记录left上的值最终的位置，即记录下比current小的数有多少

        for(int i = left + 1; i <= right; i ++) {       // 在整个for循环中left上的值没有发生变化
            if(quickArr.get(i) < current){
                swapTwoNumber(quickArr, ++index, i);   // 如果将小于current的数存放到一边
            }
        }

        swapTwoNumber(quickArr, left, index);       // 将序列从left到right中最后一个小于current的数与current交换位置
        System.out.println(quickArr);

        return index;
    }

    public static List<Integer> QuickSort(List<Integer> quickArr, int left, int right) {
        if(left < right) {
            int partitionIndex = partition_v1(quickArr, left, right);
//            int partitionIndex = partition_v2(quickArr, left, right);

            QuickSort(quickArr, left, partitionIndex - 1);
            QuickSort(quickArr, partitionIndex + 1, right);
        }
        return quickArr;
    }

    // 三路快速排序: 三路快排划分为：大于当前值的数， 等于当前值的数和小于当前值的数
    public static List<Integer> QuickSortThird(List<Integer> quickArr, int left, int right) {

        if (left >= right) {
            return quickArr;
        }

        int current = quickArr.get(left);
        int small = left, large = right + 1;            // small记录比当前值小的数，large记录比当前值大的数
        int i = left;
        while(i < large) {
            if (quickArr.get(i) < current ) {            // 小于当前值的数，则将这些数存放到数组前面来
                swapTwoNumber(quickArr, i, small + 1);
                small ++;
                i++;
            } else if (quickArr.get(i) > current) {       // 大于当前值的数，则将这些数存放到数组的后面
                swapTwoNumber(quickArr, i, large - 1);
                large --;
            } else {                                  // 等于当前值的数
                i ++;
            }
        }

        swapTwoNumber(quickArr, left, small);
        System.out.println(quickArr);
        QuickSortThird(quickArr, left, small);
        QuickSortThird(quickArr, large, right);

        return quickArr;
    }


    public static void main(String[] args) {
//        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 3, 44, 38, 5, 47, 15, 2, 4, 4, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 6, 9, 7};      //
        List<Integer> quickArr = Arrays.asList(source);

        // 快速排序

        System.out.println("快速排序前： " + Arrays.asList(quickArr));
        List<Integer> quickRes = QuickSortThird(quickArr, 0, quickArr.size() - 1);
        System.out.println("快速排序的结果为： " + quickRes);

        System.out.println(Arrays.asList(source));  // source已经变成有序序列啦

//        System.out.println("三路快速排序前： " + Arrays.asList(quickArr));
//        List<Integer> quickRes3 = QuickSortThird(quickArr, 0, quickArr.size() - 1);
//        System.out.println("三路快速排序结果为： " + quickRes3);


    }
}
