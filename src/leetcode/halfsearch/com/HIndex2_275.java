package leetcode.halfsearch.com;

/**
 * Time: 2019-06-26
 * Author: snowy
 * Leetcode 275: H-Index II
 * */

public class HIndex2_275 {
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length < 1)
            return 0;

        int count = 0;
        for(int i = citations.length - 1; i >= 0; i --) {
            if(citations[i] > count)
                count ++;
            else
                break;
        }

        return count;
    }

    public static int hIndex_hfsearch(int[] citations) {
        if(citations == null || citations.length < 1)
            return 0;

        int left = 0, right = citations.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(citations[mid] >= (citations.length - mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return citations.length - left;
    }


    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        int res = hIndex_hfsearch(citations);
        System.out.println(res);
    }

}
