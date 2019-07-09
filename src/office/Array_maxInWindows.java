package office;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Time: 2019-03-19
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 * */

public class Array_maxInWindows {

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();

        if(num == null || size < 1 || num.length < size)
            return list;

        // 用来存储可能的最大数的下标
        ArrayList<Integer> maxNumIndex = new ArrayList<>();

        // 先找出前size个中的最大值
        for(int i = 0; i < size - 1; i ++){
            for (int j = maxNumIndex.size() - 1; j >= 0 && num[maxNumIndex.get(j)] < num[i]; j --) {
                maxNumIndex.remove(j);
            }
            maxNumIndex.add(i);
        }


        for (int i = size - 1; i < num.length; i ++) {

            int j = maxNumIndex.size() - 1;
            for (; j >= 0 && num[maxNumIndex.get(j)] < num[i]; j --) {
                maxNumIndex.remove(j);
            }

            maxNumIndex.add(i);

            if(i - maxNumIndex.get(0) == size) {
                maxNumIndex.remove(0);
            }

            list.add(num[maxNumIndex.get(0)]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> maxNum = maxInWindows(nums, 3);

        System.out.println(maxNum);

    }
}
