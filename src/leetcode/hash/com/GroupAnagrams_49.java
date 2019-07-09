package leetcode.hash.com;

import java.util.*;

/**
 * Time: 2019-05-10
 * Author: snowy
 * Leetcode 49:  Group Anagrams
 * 使用hashmap和排序来做
 * 先将字符串转成字符数组，然后对字符数组进行排序，将字符数组重新拼成字符串然后存储到hash表中
 * */

public class GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length < 1 || strs == null)
            return res;

        Map<String, Integer> map = new HashMap<>();

        int index = 0;

        for(String str : strs) {
            char[] chars = str.toCharArray();       // 将字符串转成字符数组
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if(!map.containsKey(keyStr)) {
                map.put(keyStr, index ++);          // 保存到hash中
                res.add(new ArrayList<>());         // 添加新的数组
            }

            res.get(map.get(keyStr)).add(str);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        for(List<String> list:res)
            System.out.println(list);
    }
}
