package special_topic.sort.basic;

import java.util.Arrays;
import java.util.List;

import static special_topic.sort.basic.Swap.swapTwoNumber;

/**
 * 选择排序
 * Function: 选择排序就是将整个数列划分成两个部分，第一部分为有序序列，第二部分为无序序列，每操作一次都是从无序序列中取一个数加入到有序序列中
 * 选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * ######算法描述######
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 *      初始状态： 无序区为R[1..n]，有序区为空
 *      第i趟排序(i= 1，2，3 ... n-1)开始时，当前有序区和无序区分别为R[1 .. i-1]和R(i ... n)。该趟排序从当前无序区中选出
 *      关键字最小的记录R[k]，将它与无序区的第1个记录R交换，使R[1 ... i] 和 R[i+1 ... n]分别变为记录个数增加1个的新有序区
 *      和记录个数减少1个的新无序区；
 *      n - 1趟结束，数据有序化了
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmx157gYXLDH8zyJibDXSKolcr2PCXv7p6SkTloUJm502BLGnSFQw1ibVQ/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(n^2)， 最坏 O(n^2)， 最好O(n^2)，  空间复杂度O(1)， 是不稳定的
 *
 * 算法分析： 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n^2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存
 *            空间吧。理论上讲，选择排序可能也是平常排序一般人想到的最多的排序方法吧。
 * */


public class SelectionSort {

    public static List<Integer> SelectionSort(List<Integer> selectionArr) {
        for(int i = 0; i < selectionArr.size() - 1; i ++) {         // selectionArr.size() - 1：因为selectionArr.size() - 1个数据都排列好了，最后一个也就自动确定好位置了
            int minIndex = i;                                           // 寻找最小数的下标
            for (int j = i + 1; j < selectionArr.size(); j++) {
                if (selectionArr.get(minIndex) > selectionArr.get(j))   // 寻找最小的数， 确定获取当前无序区中最小的那个数的下标
                    minIndex = j;                                       // 将最小数的索引保留
            }
            if (minIndex != i) {
                swapTwoNumber(selectionArr, i, minIndex);                // 将无序区中的最小数加入到有序区中;
            }
        }

        return selectionArr;
    }

    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> selectionArr = Arrays.asList(source);               // 将数据替换成List的方式

        // 选择排序
        System.out.println("交换前： " + Arrays.asList(selectionArr));
        List<Integer> selectionRes = SelectionSort(selectionArr);
        System.out.println("选择排序的结果为： " + Arrays.asList(selectionRes));
    }
}
