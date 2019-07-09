package leetcode.hash.com;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Time: 2019-06-26
 * Author: snowy
 * Leetcode 274: H-Index
 * */

public class HIndex_274 {

    public static int hIndex(int[] citations){

        if(citations == null || citations.length < 1)
            return 0;

        int[] count = new int[citations.length + 1];
        for(int cite : citations) {
            count[Math.min(cite, citations.length)] ++;   // 将大于citations.length的数计数到citations.length中，不影响结果
        }

        int sum = 0;
        int i = citations.length;
        for(; i >= 0; i --) {
            sum += count[i];
            if(i <= sum)
                break;
        }
        return i;
    }

    public static void main(String[] args){
        int[] citation = {3, 0, 6, 1, 5};
        int res = hIndex(citation);
        System.out.println(res);
    }
}
