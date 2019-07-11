package special_topic.sort.basic;

/**
 * Author: snowy        Time: 2019/3/31
 * 希尔排序
 * Function: 希尔排序是由插入排序改进得到的。当希尔排序的间隔为1时，其实就是插入排序，因此插入排序是特殊的希尔排序
 * 1959年Shell发明，第一个突破O(n^2)的排序算法，是简单插入排序的改进版，它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序
 * ######算法描述###### 现将整个待排序的记录序列分割成为若干个子序列分别进行直接插入排序
 * 选择一个增量序列t1, t2, ..., tk, 其中ti > tj， tk = 1
 * 按增量序列个数k,对序列进行k趟排序
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m的子序列，分别对各子表进行直接插入排序。仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXm6GpRDRhiczgOdibbGBtpibtIhX4YRzibicUyEOSVh3JZBHtiaZPN30X1WOhA/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(n^1.3) || O(nlogn)， 最坏 O(n^2)， 最好O(n)，  空间复杂度O(1)， 是不稳定的
 * 算法分析：希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的
 * */

import java.util.Arrays;
import java.util.List;

public class ShellSort {
    public static List<Integer> ShellSort(List<Integer> shellArr) {
        for(int gap = shellArr.size() / 2; gap > 0; gap /= 2) {             // 间隔序列， 逐步缩小增量
            for (int i = gap; i < shellArr.size(); i ++ ) {                 // 从第gap个元素，逐个对所在组进行直接插入排序操作
                int curNum = shellArr.get(i);
                int j = i - gap;
                for(; j >= 0 && shellArr.get(j) > curNum; j -= gap) {       // 寻找最终插入的位置
                    shellArr.set(j + gap, shellArr.get(j));
                }
                shellArr.set(j + gap, curNum);                              // 插入
            }
        }

        return shellArr;
    }

    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> shellArr = Arrays.asList(source);               // 将数据替换成List的方式

        // 希尔排序
        System.out.println("希尔排序前： " + Arrays.asList(shellArr));
        List<Integer> shellRes = ShellSort(shellArr);
        System.out.println("希尔排序的结果为： " + Arrays.asList(shellRes));
    }
}
