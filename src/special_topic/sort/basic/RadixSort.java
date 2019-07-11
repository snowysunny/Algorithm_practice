package special_topic.sort.basic;

/**
 * 基数排序
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；以此类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前
 * ######算法描述######
 * 取得数组中的最大数，并取得位数
 * arr为原始数组，从最低位开始取每个位组成radix数组
 * 对radix进行计数排序（利用计数排序适用于小范围的特点）
 *
 * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXm8de0kHuzHxicmibEQaHYX65g9cwicr5aGeWWoib3uSg0XGO3QTp2vsuCxw/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(n * k)， 最坏 O(n*k)， 最好O(n*k)    空间复杂度： O(n + k）   是稳定的
 * 算法分析： 基数排序基于分别排序，分别收集，所以是稳定的。但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。
 * */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort {


    public static List<Integer> RadixSort(List<Integer> radixArr) {

        List<Integer> arrCopy = radixArr;
        int maxValue = Collections.max(arrCopy);

        for(int mod = 1; maxValue/mod > 0; mod *= 10) {     // 对基数进行桶排序
            arrCopy = count_sort(arrCopy, mod);
        }

        return arrCopy;
    }
    /**
     * 对数组按照“某个位数”进行排序（桶排序）
     *
     */
    public static List<Integer> count_sort(List<Integer> radixArr, int exp) {
        Integer[] output = new Integer[radixArr.size()];             // 存储"被排序数据"的临时数组

        int buckCount = 10;
        int[] buckets = new int[buckCount];
        Arrays.fill(buckets, 0);

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < radixArr.size(); i++)
            buckets[ (radixArr.get(i)/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < buckCount; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (int i = radixArr.size() - 1; i >= 0; i--)
        {
            output[buckets[ (radixArr.get(i)/exp)%10 ] - 1] = radixArr.get(i);
            buckets[ (radixArr.get(i)/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        radixArr = Arrays.asList(output);
        return radixArr;
    }


    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> radixArr = Arrays.asList(source);               // 将数据替换成List的方式
        // 基数排序
        System.out.println("基数排序前： " + radixArr);
        List<Integer> radixRes = RadixSort(radixArr);
        System.out.println("基数排序后： " + radixRes);
        System.out.println("基数排序前： " + radixArr);

    }
}
