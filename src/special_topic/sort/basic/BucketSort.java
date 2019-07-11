package special_topic.sort.basic;

/**
 * 桶排序
 * 桶排序是计数排序的升级版。它利用了汉书的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序的工作原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或者以递归方式继续使用桶排序进行排序）
 * ######算法描述######
 * 设置一个定量的数组当作空桶
 * 遍历输入数据，并且把数据一个一个方的放到对应的桶里去
 * 对每个不是空的桶进行排序
 * 从不是空的桶里把排好序的数据拼接起来
 *
 * 图片演示： https://mmbiz.qpic.cn/mmbiz_jpg/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmk7Gjoat6hJ4VYSNvz1A9mudGMVE7FkKMAJsZUKutDx1L1HYibPlOoSg/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1
 * 时间复杂度： 平均 O(n + k)， 最坏 O(n+k)， 最好O(n)    空间复杂度： O(n + k）   是稳定的
 * 算法分析： 桶排序最好情况下使用限行时间O(n)，桶排序的时间复杂度，取决于对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static List<Integer> BucketSort(List<Integer> bucketArr) {
        if(bucketArr.size() == 0)
            return bucketArr;

        // 获得最小值
        int minValue = Collections.min(bucketArr);
        if(minValue < 0)                // 这里桶排序考虑的均为非负整数
            return bucketArr;

        // 定义桶的数量
        int bucketCount = 10;
        List<List> buckets = new ArrayList<>();     // 定义桶
        for(int i = 0; i < bucketCount; i ++) {
            buckets.add(new ArrayList());
        }

        // 将数据放入到桶中
        for(int num : bucketArr) {
            buckets.get(num / bucketCount).add(num);
        }

        // 每个桶中使用插入排序
        for(int i = 0; i < bucketCount; i++){
            InsertionSort.InsertionSort(buckets.get(i));
        }

        List<Integer> res = new ArrayList<>();
        // 保存结果
        for(int i = 0; i < bucketCount; i++) {
            res.addAll(buckets.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> arr = Arrays.asList(source);               // 将数据替换成List的方式
        // 桶排序
        System.out.println("桶排序前： " + arr);
        List<Integer> bucketRes = BucketSort(arr);
        System.out.println("桶排序结果为：" + bucketRes);
    }

}
