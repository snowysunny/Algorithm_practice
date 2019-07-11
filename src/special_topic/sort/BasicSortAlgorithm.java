package special_topic.sort;

/**
 * Time: 2019-02-06         Author: snowy
 * DESC: 不同排序算法的实现
 * */

import java.util.*;

public class BasicSortAlgorithm {

    // List中的两数交换
    public static void Swap(List<Integer> arr, int left, int right) {
        int temp = arr.get(left);
        arr.set(left, arr.get(right));
        arr.set(right, temp);
    }

    //////////////////////////比较排序////////////////////////////

    /**
     * 冒泡排序
     * Function: 正常的冒泡排序是先将最大的数据归好位置，然后是次大，以此类推，最后将整个数列排列好
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢浮到数列的顶端
     * ######算法描述######
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数
     * 针对所有的元素重复以上的步骤，除了最后一个
     * 重复步骤1-3，直到排序完成
     * ####################
     *
     * 动态图： https://mmbiz.qpic.cn/mmbiz_gif/951TjTgiabkzow2ORRzgpfHIGAKIAWlXmYTANnYjhiaAU3RyxWw2WyWaicgZmfuyYP1s5iaUQaJh3ShGog3XliceqTw/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1
     * 时间复杂度： 平均 O(n^2)， 最坏 O(n^2)， 最好O(n)，  空间复杂度O(1)， 是稳定的
     * */
    public static List<Integer> BubbleSort(List<Integer> bubbleArr) {
        for(int i = 0; i < bubbleArr.size() - 1; i ++) {
            boolean flag = true;        // 用于标记，记录该数组是否已经为有序序列
            // j的最大值为arr.size() - 1 - i， 减去i是因为大的数据已经在对应的位置上了
            for (int j = 0; j < bubbleArr.size() - 1 - i; j++) {
                if(bubbleArr.get(j) > bubbleArr.get(j + 1)) {       // 相邻两个数进行比较，如果顺序错位则进行替换
                    flag = false;
                    Swap(bubbleArr, j, j + 1);
//                    int temp = arr.get(j);
//                    arr.set(j, arr.get(j + 1));         // 列表的替换
//                    arr.set(j + 1, temp);
                }
            }
            if (flag)           // 该数列已经为有序序列了
                break;
        }
        return bubbleArr;
    }

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
    public static List<Integer> SelectionSort(List<Integer> arr) {
        for(int i = 0; i < arr.size() - 1; i ++) {
            int minIndex = i;                           // 寻找最小数的下标
            for(int j = i + 1; j < arr.size(); j++) {
                if(arr.get(j) < arr.get(minIndex))      // 寻找最小的数， 确定获取当前无序区中最小的那个数的下标
                    minIndex = j;                       // 将最小数的索引保留
            }
            if (minIndex != i) {                        // 将无序区中的最小数加入到有序区中
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
        return arr;
    }

    /**
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
    public static List<Integer> InsertionSort(List<Integer> arr) {
        for(int i = 1; i <= arr.size() - 1; i ++) {             // 遍历数组
            int current = arr.get(i);
            int j = i - 1;
            for(; j >= 0 && arr.get(j) > current; j --) {       // 遍历已经排好序的序列，找到当前数应该插入的位置
                arr.set(j + 1, arr.get(j));                     // 把已排序元素逐步向后挪位
            }
            arr.set(j + 1, current);                            // 将数据插入到当前序列相应的位置
        }
        return arr;
    }

    /**
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
    public static List<Integer> ShellSort(List<Integer> arr) {
        for(int gap = arr.size()/2; gap > 0; gap /= 2) {            // 间隔序列， 逐步缩小增量
            for(int i = gap; i < arr.size(); i ++) {                // 从第gap个元素，诸葛对所在组进行直接插入排序操作
                int current = arr.get(i);                           //
                int j = i - gap;
                for(; j >= 0 && arr.get(j) > current; j -= gap)
                    arr.set(j+gap, arr.get(j));
                arr.set(j + gap, current);
            }
        }
        return arr;
    }

    /**
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
    // 二路归并，将两个有序序列进行合并
    public static List<Integer> Merge(List<Integer> leftArr, List<Integer> rightArr) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        while(left < leftArr.size() && right < rightArr.size()) {
            if(leftArr.get(left) <= rightArr.get(right)) {
                result.add(leftArr.get(left));
                left ++;
            }
            else {
                result.add(rightArr.get(right));
                right ++;
            }
        }
        if(left == leftArr.size()) {
            for(int i = right; i < rightArr.size(); i ++)
                result.add(rightArr.get(i));
        } else {
            for(int i = left; i < leftArr.size(); i ++)
                result.add(leftArr.get(i));
        }

        return result;
    }
    // 归并排序
    public static List<Integer> MergeSort(List<Integer> arr) {
        if(arr.size() < 2)          // 递归结束的条件
            return arr;

        int middle = arr.size() / 2;        // 将数组划分成两部分

        // 将数组划分成左右两部分
        List<Integer> leftArr = arr.subList(0, middle);
        List<Integer> rightArr = arr.subList(middle, arr.size());

        return Merge(MergeSort(leftArr), MergeSort(rightArr));          // 进行递归合并
    }

    /**
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
    public static int partition(List<Integer> arr, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i ++) {
            if(arr.get(i) < arr.get(left)) {
//                int temp = arr.get(i);
//                arr.set(i, arr.get(index));
//                arr.set(index, temp);
                Swap(arr, i, index);
                index ++;
            }
        }
        // 两数交换
        Swap(arr, left, index - 1);
//        int temp = arr.get(left);
//        arr.set(left, arr.get(index - 1));
//        arr.set(index - 1, temp);           // 将该数据存放到数组排好序的对应的位置上
        System.out.println(arr);
        System.out.println(arr.get(index - 1));
        return index - 1;
    }

    public static List<Integer> QuickSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            QuickSort(arr, left, partitionIndex - 1);
            QuickSort(arr, partitionIndex + 1, right);
        }
//        System.out.println(arr);
        return arr;
    }

    // 三路快速排序: 三路快排划分为：大于当前值的数， 等于当前值的数和小于当前值的数
    public static List<Integer> QuickSortThird(List<Integer> arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int current = arr.get(left);
        int small = left, large = right + 1;            // small记录比当前值小的数，large记录比当前值大的数
        int i = left;
        while(i < large) {
            if (arr.get(i) < current ) {            // 小于当前值的数，则将这些数存放到数组前面来
                Swap(arr, i, small + 1);
                small ++;
                i++;
            } else if (arr.get(i) > current) {       // 大于当前值的数，则将这些数存放到数组的后面
                Swap(arr, i, large - 1);
                large --;
            } else {                                  // 等于当前值的数
                i ++;
            }
        }

        Swap(arr, left, small);
        System.out.println(arr);
        QuickSortThird(arr, left, small);
        QuickSortThird(arr, large, right);

        return arr;
    }

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
    public static void HeapAdjust(List<Integer> arr, int parent, int length) {
        int current = arr.get(parent);             // 保存当前父节点

        int child = parent * 2 + 1;                // 先获取左孩子结点的下标

        while(child < length) {
            // 如果有右孩子结点， 并且右孩子结点的值大于左孩子结点， 则取右孩子结点
            if(child + 1 < length && arr.get(child) < arr.get(child + 1)) {
                child ++;           // 右孩子结点的下标
            }

            // 如果父节点已经大于孩子结点的值，则直接结束
            if (current >= arr.get(child))
                break;

            // 把孩子结点的值赋给父节点
            arr.set(parent, arr.get(child));

            // 选取孩子结点的左孩子结点，继续向下筛选
            parent = child;
            child = parent * 2 + 1;
        }

        arr.set(parent, current);
    }
    public static List<Integer> HeapSort(List<Integer> arr) {
        // 第一步： 循环从而建立起初始堆
        for (int i = arr.size()/2; i>= 0; i --) {       // arr.size()/2 为叶子结点的个数
            HeapAdjust(arr, i, arr.size());
//            System.out.println(arr);
        }


        // 第二步： 进行n-1次循环，完成排序
        for (int i = arr.size() - 1; i > 0; i--) {

//            System.out.println(arr);
            // 最后一个元素和第一个元素进行交换
            Swap(arr, 0, i);

            // 筛选R[0]结点，得到i-1个结点的堆
            HeapAdjust(arr, 0, i);
        }

        return arr;
    }

    //////////////////////////非比较排序////////////////////////////
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
    public static List<Integer> CountingSort(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        int maxValue = Collections.max(arr);
        int minValue = Collections.min(arr);

        if (minValue < 0)
            return arr;
        int[] bucket = new int[maxValue + 1];
        Arrays.fill(bucket, 0);

        for(int index : arr) {
            bucket[index] ++;
        }

        for(int i = 0; i <= maxValue; i++) {
            if (bucket[i] == 0)
                continue;
            for(int j = 0; j < bucket[i]; j ++)
                res.add(i);
        }
        return res;
    }

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
    public static List<Integer> BucketSort(List<Integer> arr) {
        if(arr.size() == 0)
            return arr;

        // 获得最小值
        int minValue = Collections.min(arr);
        if(minValue < 0)
            return arr;

        // 定义桶的数量
        int bucketCount = 10;
        List<List> buckets = new ArrayList<>();     // 定义桶
        for(int i = 0; i < bucketCount; i ++) {
            buckets.add(new ArrayList());
        }

        // 将数据放入到桶中
        for(int num : arr) {
            buckets.get(num / bucketCount).add(num);
        }

        // 每个桶中使用插入排序
        for(int i = 0; i < bucketCount; i++){
            InsertionSort(buckets.get(i));
        }

        List<Integer> res = new ArrayList<>();
        // 保存结果
        for(int i = 0; i < bucketCount; i++) {
            res.addAll(buckets.get(i));
        }
        return res;
    }

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
    public static List<Integer> RadixSort(List<Integer> arr) {

        List<Integer> arrCopy = arr;
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
    public static List<Integer> count_sort(List<Integer> arr, int exp)
    {
        Integer[] output = new Integer[arr.size()];             // 存储"被排序数据"的临时数组

        int[] buckets = new int[10];
        Arrays.fill(buckets, 0);

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < arr.size(); i++)
            buckets[ (arr.get(i)/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (int i = arr.size() - 1; i >= 0; i--)
        {
            output[buckets[ (arr.get(i)/exp)%10 ] - 1] = arr.get(i);
            buckets[ (arr.get(i)/exp)%10 ]--;
        }

        // 将排序好的数据赋值给a[]
        arr = Arrays.asList(output);
        return arr;
    }

    public static void main(String[] args) {
//        List<Integer> arr = new ArrayList<>();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> arr = Arrays.asList(source);               // 将数据替换成List的方式

        // 冒泡排序
//        List<Integer> bubbleArr = Arrays.asList(source);
//        System.out.println("冒泡排序前： " + bubbleArr);
//        List<Integer> bubbleRes = BubbleSort(bubbleArr);
//        System.out.println("冒泡排序的结果为： " + bubbleRes);




        // 选择排序
//        System.out.println("交换前： " + Arrays.asList(arr));
//        List<Integer> selectionRes = SelectionSort(arr);
//        System.out.println("选择排序的结果为： " + Arrays.asList(selectionRes));

        // 插入排序
//        System.out.println("插入排序前： " + Arrays.asList(arr));
//        List<Integer> insertionRes = InsertionSort(arr);
//        System.out.println("插入排序的结果为： " + Arrays.asList(insertionRes));

        // 希尔排序
//        System.out.println("希尔排序前： " + Arrays.asList(arr));
//        List<Integer> shellRes = ShellSort(arr);
//        System.out.println("希尔排序的结果为： " + Arrays.asList(shellRes));

        // 归并排序
//        System.out.println("归并排序前： " + Arrays.asList(arr));
//        List<Integer> mergeRes = MergeSort(arr);
//        System.out.println("归并排序的结果为： " + Arrays.asList(mergeRes));

        // 快速排序
//        System.out.println("快速排序前： " + Arrays.asList(arr));
//        List<Integer> quickRes = QuickSort(arr, 0, arr.size() - 1);
//        System.out.println("快速排序的结果为： " + quickRes);

//        System.out.println("三路快速排序前： " + Arrays.asList(arr));
//        List<Integer> quickRes3 = QuickSortThird(arr, 0, arr.size() - 1);
//        System.out.println("三路快速排序结果为： " + quickRes3);

        // 堆排序
//        System.out.println("堆排序前： " + arr);
//        List<Integer> heapRes = HeapSort(arr);
//        System.out.println("堆排序结果为： " + heapRes);


        // 计数排序
        System.out.println("计数排序前： " + arr);
        List<Integer> countingRes = CountingSort(arr);
        System.out.println("计数排序结果为： " + countingRes);

        // 桶排序
        System.out.println("桶排序前： " + arr);
        List<Integer> bucketRes = BucketSort(arr);
        System.out.println("桶排序结果为：" + bucketRes);

        // 基数排序
        System.out.println("基数排序前： " + arr);
        List<Integer> radixRes = RadixSort(arr);
        System.out.println("基数排序后： " + radixRes);
        System.out.println("基数排序前： " + arr);
//        System.out.println("交换前： " + Arrays.asList(arr));
//        Swap(arr, 0, arr.size() - 1);
//        System.out.println("交换后： " + Arrays.asList(arr));
    }
}