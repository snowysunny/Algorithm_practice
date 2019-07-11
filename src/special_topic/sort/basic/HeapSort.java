package special_topic.sort.basic;

/**
 * 堆排序: 参考  https://www.cnblogs.com/jingmoxukong/p/4303826.html#java版本
 * Function: 堆排序主要分为两个部分，第一部分为初始建堆， 第二部分为得到当前最大值或者是最小值
 * 堆排序的基本思想：堆排序是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点
 * ######算法描述######
 * 将初始待排序关键字序列(R1, R2, ... Rn)构建成大顶堆，此堆为初始的无序区
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1, R2, ..., Rn-1) 和新的有序区(Rn)，且满足R[1, 2, ..., n-1]<=r[n]
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要堆当前无序区(R1, R2, ..., Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1, R2, ... Rn-2)和新的有序区(Rn-1, Rn)。不断
 * 重复此过程知道有序区的元素个数为n-1，则整个排序过程完成
 * ####################
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmcW0GonHkXQajLiaj8g5b6J4AofRe4iaofXUutpk61UpzTv2fUzWvRUjg/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(nlogn)， 最坏 O(nlogn)， 最好O(nlogn)，  空间复杂度O(1)， 是不稳定的
 * 解析： 堆排序在排序算法中算是比较复杂的，要点在于使用数据实现堆的时候，父节点与其孩子结点的下标对应，
 *        当前元素在数组中以R[i]表示，那么：
 *        （1）它的左孩子结点是： R[2 * i +1]
 *        （2）它的右孩子结点是： R[2 * i +2]
 *        （3）它的父结点为： R[(i - 1) / 2]
 * */

import java.util.Arrays;
import java.util.List;

import static special_topic.sort.basic.Swap.swapTwoNumber;

public class HeapSort {
    public static void HeapAdjust(List<Integer> heapArr, int parent, int length) {
        int current = heapArr.get(parent);

        int child = 2 * parent + 1;     // 左孩子
        while(child < length) {
            if (child + 1 < length && heapArr.get(child) < heapArr.get(child + 1))      // 如果有右孩子结点， 并且右孩子结点的值大于左孩子结点， 则取右孩子结点
                child += 1;             // 右孩子

            // 如果父节点已经大于孩子结点的值，则直接结束
            if(current >= heapArr.get(child))
                break;

            // 把孩子结点的值赋给父节点
            heapArr.set(parent, heapArr.get(child));

            // 选取孩子结点的左孩子结点，继续向下筛选
            parent = child;
            child = 2 * parent + 1;
        }

        heapArr.set(parent, current);

    }

    public static List<Integer> HeapSort(List<Integer> heapArr) {
        // 第一步： 循环从而建立起初始堆
        for(int i = heapArr.size() / 2 - 1; i >= 0; i --) {      // heapArr.size()/2 为叶子结点的个数,
            // 从第一个非叶子结点开始构建大顶堆
            HeapAdjust(heapArr, i, heapArr.size());
        }
        //第二步： 调整堆结构+交换堆顶元素与末尾元素
        for(int i = heapArr.size() - 1; i >= 0; i --) {
            //将堆顶元素与末尾元素进行交换
            swapTwoNumber(heapArr, 0, i);
            //重新对堆进行调整
            HeapAdjust(heapArr, 0, i);
        }

        return heapArr;
    }

    public static void main(String[] args) {
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        List<Integer> heapArr = Arrays.asList(source);
        // 堆排序
        System.out.println("堆排序前： " + heapArr);
        List<Integer> heapRes = HeapSort(heapArr);
        System.out.println("堆排序结果为： " + heapRes);
    }
}
