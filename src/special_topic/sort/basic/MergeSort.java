package special_topic.sort.basic;

/**
 * Author: snowy        Time: 2019/3/31
 * 归并排序
 * Function: 归并排序使用分治方法进行排序，使用递归的方式进行实现
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法(Divude and Conquer)的一个非常典型的应用。将已有的子序列合并，得到完全有序的序列；
 *  即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，成为2-路归并。
 * ######算法描述######
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序
 * 将两个排序好的子序列合并成一个最终的排序序列
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXme9BR4OOicbVtD5OYT4HZ36lhMtlKiava7mcgbtNR8o9ibGdqOL7xgAFAQ/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(nlogn)， 最坏 O(nlogn)， 最好O(nlogn)，  空间复杂度O(n)， 是稳定的
 * 算法分析：归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn)的时间复杂度。代价是需要额外的存储空间
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    // 二路归并， sortedArr1， sortedArr2均为有序序列
    public static List<Integer> Merge(List<Integer> sortedArr1, List<Integer> sortedArr2) {
        List<Integer> sortRes = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while(i < sortedArr1.size() && j < sortedArr2.size()) {
            // 比较sortedArr1和sortedArr2中的元素大小
            if (sortedArr1.get(i) <= sortedArr2.get(j)) {
                sortRes.add(k, sortedArr1.get(i));
                i ++;
            } else {
                sortRes.add(k, sortedArr2.get(j));
                j ++;
            }

            k ++;
        }

        // 如果sortedArr1中的元素已经全部加入到sortRes中了，将sortedArr2剩余的元素添加到sortedRes中
        if (i == sortedArr1.size()) {
            sortRes.addAll(k, sortedArr2.subList(j, sortedArr2.size()));
        }
        // 如果sortedArr2中的元素已经全部加入到sortRes中了，将sortedArr1剩余的元素添加到sortedRes中
        if (j == sortedArr2.size()) {
            sortRes.addAll(k, sortedArr1.subList(i, sortedArr1.size()));
        }

        return sortRes;
    }

    public static List<Integer> MergeSort(List<Integer> mergeArr) {
        if(mergeArr.size() <= 1)         // 递归结束的条件
            return mergeArr;

        // 将序列递归切分
        List<Integer> leftArr = MergeSort(mergeArr.subList(0, mergeArr.size() / 2));
        List<Integer> rightArr = MergeSort(mergeArr.subList(mergeArr.size() / 2, mergeArr.size()));

        return Merge(leftArr, rightArr);        // 进行递归合并
    }

    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> arr = Arrays.asList(source);               // 将数据替换成List的方式

        // 归并排序
        System.out.println("归并排序前： " + Arrays.asList(arr));
        List<Integer> mergeRes = MergeSort(arr);
        System.out.println("归并排序的结果为： " + Arrays.asList(mergeRes));

    }
}
