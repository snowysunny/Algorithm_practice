package leetcode.sort.com;

/**
 * Time: 2019-06-14
 * Auhor: snowy
 * Leetcode 220: Contains Duplicate III
 * */

public class ContainsDuplicateIII_220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;

        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length && j <= i + k; j ++) {
                long diff = Math.abs(nums[i] - nums[j]);
                if(diff > Integer.MAX_VALUE) {
                    if(diff - Integer.MAX_VALUE <= t)
                        return true;
                } else {
                    if(diff <= t)
                        return true;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        int k = 2, t = 3;
        boolean res = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(res);
        long ab = Math.abs((long)-1 - 2147483647);
        if(ab == -2147483648)
            System.out.println(false);
        System.out.println(ab);
    }
}
