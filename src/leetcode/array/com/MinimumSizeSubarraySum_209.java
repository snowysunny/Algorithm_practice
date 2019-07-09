package leetcode.array.com;

public class MinimumSizeSubarraySum_209 {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int start = 0;      // 记录开始的地方
        int sum = 0;        // 记录当前的和
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i ++) {
            sum +=  nums[i];
            while(sum >= s) {
                minLen = Math.min(i - start + 1, minLen);
                sum -= nums[start ++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        int res = minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
