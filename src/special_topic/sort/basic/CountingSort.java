package special_topic.sort.basic;

/**
 * 计数排序
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数
 * ######算法描述######
 * 找到待排序的数组中最大和最小的元素
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 *
 * 动态图：https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmRdDMUVcrboBpKl9lfLic2TE8zHNcHfCktRhQ9EfVbFoEAet0iaQOge1w/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
 * 时间复杂度： 平均 O(n + k)， 最坏 O(n+k)， 最好O(n + k)    空间复杂度： O(n + k)   是稳定的
 * 算法分析： 计数排序是一个稳定的排序算法。当输入的元素是n个0到k之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)，其牌序速度快于任何比较排序算法。当k不是很大并且序列比较集中时，计数排序是一个很有效的排序算法。
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    public static List<Integer> CountingSort(List<Integer> countingArr) {
        int max = Collections.max(countingArr);
        int min = Collections.min(countingArr);

        int[] countArr = new int[max - min + 1];            // 用于统计的数组
        Arrays.fill(countArr, 0);

        for (int i = 0; i < countingArr.size(); i ++) {
            countArr[countingArr.get(i) - min] ++ ;         // 进行统计
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < countArr.length; i ++) {
            if(countArr[i] == 0)
                continue;
            for(int j = 0; j < countArr[i]; j ++)
                res.add(i + min);
        }
        return res;
    }

    public static void main(String[] args) {
        //        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> arr = Arrays.asList(source);               // 将数据替换成List的方式
        // 计数排序
        System.out.println("计数排序前： " + arr);
        List<Integer> countingRes = CountingSort(arr);
        System.out.println("计数排序结果为： " + countingRes);
    }
}
