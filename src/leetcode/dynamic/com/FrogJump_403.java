package leetcode.dynamic.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Time: 2019-07-06
 * Author: snowy
 * Leetcode 403: Frog Jump
 * */

public class FrogJump_403 {

    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();           // 存储到达当前位置上时跳的步数大小

        for(int stone : stones)
            map.put(stone, new HashSet<Integer>());

        map.get(0).add(0);

        for(int i = 0; i < stones.length; i ++) {
            for(int step : map.get(stones[i])) {
                for(int k = step - 1; k <= step + 1; k ++) {
                    if(k > 0 && map.containsKey(stones[i] + k)) {
                        map.get(stones[i] + k).add(k);
                    }
                }
            }
        }

        return map.get(stones[stones.length - 1]).size() > 0 ? true : false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        boolean res = canCross(stones);
        System.out.println(res);

    }
}
