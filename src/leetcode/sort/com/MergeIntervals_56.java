package leetcode.sort.com;

import leetcode.listnode.com.ListNode;

import java.util.*;

/**
 * Time: 2019-05-13
 * Author: snowy
 * Leetcode 56: Merge Intervals
 * */

public class MergeIntervals_56 {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 1 || intervals[0].length < 1)
            return new int[1][];

        // 按照第一个字段进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            if(interval[0] >= res.get(res.size() - 1)[0] && interval[0] <= res.get(res.size() - 1)[1]) {
                if(interval[1] >= res.get(res.size() - 1)[1])
                    res.get(res.size() - 1)[1] = interval[1];
            } else
                res.add(interval);
        }

        int[][] arr = new int[res.size()][];

        int[][] ans = res.toArray(arr);

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{15,18},{8,10},{2,6}};
        int[][] ans = merge(intervals);

        for(int[] res : ans)
            System.out.println(Arrays.toString(res));

    }
}
