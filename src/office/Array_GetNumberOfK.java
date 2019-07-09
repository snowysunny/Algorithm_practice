package office;

/**
 * Time: 2019-04-10
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * */

public class Array_GetNumberOfK {

    // 二分查找，查找第一个k和最后一个k的位置
    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length < 1)
            return 0;

        int first = getFirstK(array, k);
        int last = getLastK(array, k);

        return last - first + 1;
    }

    public static int getFirstK(int[] array, int k) {
        int low = 0, high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(array[mid] > k) {
                high = mid - 1;
            } else if(array[mid] < k) {
                low = mid + 1;
            } else {
                if (mid > 0 && array[mid - 1] == k)
                    high = mid - 1;
                else
                    return mid;
            }
        }
        return -1;
    }

    public static int getLastK(int[] array, int k) {
        int low = 0, high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(array[mid] > k) {
                high = mid - 1;
            } else if(array[mid] < k) {
                low = mid + 1;
            } else {
                if (mid < array.length - 1 && array[mid + 1] == k)
                    low = mid + 1;
                else
                    return mid;
            }
        }
        return -2;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int first = GetNumberOfK(array, 3);
        System.out.println(first);
    }
}
