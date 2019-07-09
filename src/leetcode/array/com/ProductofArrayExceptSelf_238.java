package leetcode.array.com;

public class ProductofArrayExceptSelf_238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int multi = 1;
        for(int i = 0; i < nums.length; i ++) {
            output[i] = multi;                      // 存储到当前数之前的数的乘积
            multi *= nums[i];
        }

        multi = 1;
        for(int i = nums.length - 1; i >= 0; i --) {
            output[i] *= multi;
            multi *= nums[i];                   // 存储从右向左到当前数的乘积
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println(result);
    }
}
