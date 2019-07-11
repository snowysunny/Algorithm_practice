package special_topic.sort.basic;

/**
 * Author: snowy        Time: 2019/03/30
 * 插入排序
 * Function: 插入排序其实是每扫描一个数据，将到当前数据为止的数列排好序，每扫一个数据，将数据插入到已排好序的列表中
 * 插入排序的算法是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * ######算法描述######一般来说，插入排序都采用in-place在数组上实现
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2-5。
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmC96MboiaHeWD5mX8KcO6ZnQTeicJ4oT33nA0fLFjY6dkDdickB4sjq6CA/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(n^2)， 最坏 O(n^2)， 最好O(n)，  空间复杂度O(1)， 是稳定的
 * 算法分析： 插入排序在实现上，通常采用in-place排序（即只需要用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为新元素提供插入空间
 * */

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static List<Integer> InsertionSort(List<Integer> insertionArr) {
        for(int i = 1; i < insertionArr.size(); i++) {                  // 遍历数组
            Integer curNum = insertionArr.get(i);
            int j = i - 1;
            for (; j >= 0 && insertionArr.get(j) > curNum; j --) {      // 遍历已经排好序的序列，找到当前数应该插入的位置
                insertionArr.set(j + 1, insertionArr.get(j));           // 把已排序元素逐步向后挪位
            }
            insertionArr.set(j + 1, curNum);                            // 将数据插入到当前序列相应的位置
        }

        return insertionArr;
    }

    public static void main(String[] args){
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        List<Integer> insertionArr = Arrays.asList(source);

        // 插入排序
        System.out.println("插入排序前： " + Arrays.asList(insertionArr));
        List<Integer> insertionRes = InsertionSort(insertionArr);
        System.out.println("插入排序的结果为： " + Arrays.asList(insertionRes));
    }
}
