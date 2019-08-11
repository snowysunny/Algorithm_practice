package special_topic.bigData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 大数据量下面寻找中位数
 * 面试题常考： 10G的数据量， 1G的内存，如何寻找到中位数
 * 使用桶排序，对整个数据进行分桶统计， 然后查找特定桶中的第k大的数，对于寻找第k大的数这里可以使用计数排序，因为桶里面的数的范围相对固定
 * */

public class FindMedian {
    /**
     * 1. 首先分桶计数
     * 2. 然后寻找桶中的数
     * */
    public static int findMedian(int[] bucketArr, int mid, int bucketNum) {
        if(bucketArr == null || bucketArr.length < 1)
            return -1;

        mid = bucketArr.length / 2;

        int[] bucketCount = new int[bucketNum];

        for(int num : bucketArr)        // 分桶计数
            bucketCount[num / bucketNum] ++;

        int amount = 0;
        int pre = 0;
        int index = 0;
        for(int i = 0; i < bucketNum; i ++) {
            pre = amount;
            amount += bucketCount[i];
            if(amount >= mid) {
                index = i;
                break;
            }
        }

        int res = 0;
        /**
         * 有几种情况：
         *              1. 如果bucketArr中数据量是奇数，那么该值就在 bucketCount[index]中
         *              2. 如果bucketArr中数据量是偶数， 如果amount > mid, 那么该值就在 bucketCount[index]中， 否则 中位数落在了bucketCount[index]和bucketCount[index + 1]
         * */
        if(bucketArr.length % 2 == 0 && amount == mid + 1) {  // 这种情况需要对两个部分进行排序
            int min = Integer.MAX_VALUE, max = 0;
            for(int num : bucketArr) {
                if(num / bucketNum == index)
                    max = Math.max(max, num);
                else if(num / bucketNum == index + 1)
                    min = Math.min(min, num);
            }

            res = (min + max) / 2;

        } else {
            List<Integer> list = new ArrayList<>();
            for(int num : bucketArr) {
                if(num / bucketNum == index)
                    list.add(num);
            }
            if(bucketArr.length % 2 == 0) {
                int first = findKLargeNumber(list, mid - pre + 1, index * bucketNum, (index + 1) * bucketNum);
                int second = findKLargeNumber(list, mid - pre + 2, index * bucketNum, (index + 1) * bucketNum);
                res = (first + second) / 2;
            } else
                res = findKLargeNumber(list, mid - pre + 1, index * bucketNum, (index + 1) * bucketNum);
        }

        return res;
    }

    // 寻找一个数组中第k大的数, 因为该数组的数据是比较集中的，并且可以知道最小值和最大值会是多少，所以可以考虑使用计数排序,
    public static int findKLargeNumber(List<Integer> array, int k, int smallest, int largest) {
        int length = largest - smallest + 1;
        int[] countNum = new int[length];
        for(int num : array)        // 统计计数
            countNum[num - smallest] ++;

        int count = 0;      // 计数
        int index = 0;      // 返回的值
        for(int i = 0; i < length; i ++) {
            count += countNum[i];
            if(count >= k) {
                index = i + smallest;
                break;
            }
        }
        return index;
    }


    public static int sortedWay(int[] buckestArr) {
        int mid = buckestArr.length / 2;
        Arrays.sort(buckestArr);
        int res = -1;
        if(buckestArr.length % 2 == 0)
            res = (buckestArr[mid] + buckestArr[mid + 1]) / 2;
        else
            res = buckestArr[mid];

        return res;
    }

    public static void main(String[] args) {
//        int[] buckestArr = {4, 5, 8, 2, 6, 8, 8, 8, 2, 4, 6, 6, 8, 8};

        Runtime run = Runtime.getRuntime();

        // 生成随机数的个数
        int length = 500000000;
        // 桶的个数
        int bucketNum = (int)Math.ceil(Math.sqrt(length)) + 20;
        // 生成随机数
        int[] buckestArr = new int[length];
        for(int i = 0; i < buckestArr.length; i ++){
            int j = (int)(Math.random() * length);
            buckestArr[i] = j;
        }

        // 内存使用情况
        long startMem1 = run.totalMemory()-run.freeMemory();
        long endMem1 = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + endMem1 );
        System.out.println("memory difference:" + (endMem1-startMem1));

        // 时间
        System.out.println("time: " + (new Date()));

        // 分桶的方式找中位数
        int res = findMedian(buckestArr, buckestArr.length / 2, bucketNum);
        System.out.println(res);

        long startMem2 = run.totalMemory()-run.freeMemory();
        long endMem2 = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + endMem2 );
        System.out.println("memory difference:" + (endMem2 - startMem2));
        System.out.println("time: " + (new Date()));

        // 正常的排序方式找中位数
        int midden = sortedWay(buckestArr);
        System.out.println(midden);

        long startMem3 = run.totalMemory()-run.freeMemory();
        long endMem3 = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + endMem3 );
        System.out.println("memory difference:" + (endMem3 - startMem3));
        System.out.println("time: " + (new Date()));
    }

}
