package leetcode.sort.com;

/**
 * Time: 2019-07-06
 * Author: snowy
 * Leetcode 215: Kth Largest Element in an Array
 * */

public class KthLargestElementinanArray_215 {
    // 快排的思想
    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return -1;

        int index = nums.length - k;
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int quivor = quickSort(nums, left, right);

            if(quivor == index)
                return nums[quivor];

            if(quivor > index)
                right = quivor - 1;

            else
                left = quivor + 1;
        }

        return nums[left];
    }

    public static int quickSort(int[] nums, int left, int right) {
        int temp = nums[left];

        while(left < right) {
            while(left < right && nums[right] >= temp)
                right --;

            if(left < right)
                nums[left] = nums[right];

            while(left < right && nums[left] <= temp)
                left ++;

            if(left < right)
                nums[right] = nums[left];
        }

        nums[left] = temp;

        return left;
    }

    // 使用堆排序的方式，这个效率更高
    public static int findKthLargest_Heap(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return -1;

        for(int i = k / 2 - 1; i >= 0; i --)
            HeapAdjust(nums, i, k);

        for(int i = k; i < nums.length; i ++) {
            if(nums[i] <= nums[0])
                continue;
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            HeapAdjust(nums, 0, k);
        }

        return nums[0];
    }

    // 建立小顶堆
    public static void HeapAdjust(int[] nums, int parent, int length) {
        int temp = nums[parent];
        int child = 2 * parent + 1;

        while(child < length) {
            if(child + 1 < length && nums[child] > nums[child + 1])
                child ++;

            if(temp <= nums[child])
                break;

            nums[parent] = nums[child];

            parent = child;
            child = 2 * parent + 1;
        }

        nums[parent] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }

}
