package leetcode.sort.com;

import java.util.*;

/**
 * Time: 2019-05-30
 * Author: snowy
 * Leetcode 57: Insert Interval
 * */

public class InsertInterval_57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval == null || newInterval.length < 2)
            return intervals;

//        if(intervals == null || intervals.length < 1)
//            return intervals;

        List<int[]> list = new ArrayList<>();
        list.add(newInterval);

        for(int[] interval : intervals) {
            list.add(interval);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] res = combine(list);

        return res;
    }

    // 下面是第56题的思想，还是需要做一些相对更基础一些的题目才行
    public static int[][] combine(List<int[]> intervals) {
        List<int[]> list = new ArrayList<>();
        list.add(intervals.get(0));

        for(int i = 1; i < intervals.size(); i ++) {
            if(list.get(list.size() - 1)[1] >= intervals.get(i)[0]) {
                if(intervals.get(i)[1] > list.get(list.size() - 1)[1])
                    list.get(list.size() - 1)[1] = intervals.get(i)[1];
            } else {
                list.add(intervals.get(i));
            }
        }

        int[][] arr = new int[list.size()][];
        int[][] res = list.toArray(arr);

        return res;
    }



    public static void main(String[] args) {
        int[][] intervals = {}; //{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};

        int[][] res = insert(intervals, newInterval);
        for(int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
