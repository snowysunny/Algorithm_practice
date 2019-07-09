package office;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        // 大顶堆中的元素均小于大顶堆中的元素
        if (count % 2 == 0) {
            // 当数据综述为偶数时，新加入的元素应县进入小顶堆中，注意不是直接进入到小顶堆中(注意不是直接进入小顶堆，而是经过大顶堆筛选后取大顶堆中最大元素进入小顶堆)
            // 新加入的元素进入大顶堆，由大顶堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filterMaxNum = maxHeap.poll();
            minHeap.offer(filterMaxNum);
        } else {
            // 当数据总数为奇数的时候，新加入的元素，应当进入大顶堆，注意不是直接进入大顶堆，而是经过小顶堆选出最大的元素进入大顶堆
            // 新加入的元素先加入小顶堆，由小顶堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filterMinNum = minHeap.poll();
            maxHeap.offer(filterMinNum);
        }
        count ++;
    }

    public Double GetMedian() {
        if (count % 2 == 0)
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;

        return new Double(minHeap.peek());
    }

    public static void main(String[] args) {

    }
}
