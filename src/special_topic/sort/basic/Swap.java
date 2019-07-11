package special_topic.sort.basic;

import java.util.Arrays;
import java.util.List;

/**
 * 两数的交换
 * */

public class Swap {
    public static void swapTwoNumber(List<Integer> arr, int index1, int index2) {
        if(index1 >= arr.size() || index2 > arr.size() || arr == null)
            return;

        Integer temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }

    public static void main(String[] args) {
        Swap sp = new Swap();
        Integer[] source = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};//{1, 3, 5, 7, 8, 2, 4, 6, 9, 7};
        List<Integer> arr = Arrays.asList(source);               // 将数据替换成List的方式

        System.out.println(Arrays.asList(arr));
        sp.swapTwoNumber(arr, 0, 1);
        System.out.println(Arrays.asList(arr));
    }
}
