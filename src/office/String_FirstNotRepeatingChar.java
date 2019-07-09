package office;

/**
 * Time: 2019-04-10
 * Author: snowy
 * Link: https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * */

import java.util.HashMap;
import java.util.Map;

public class String_FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        if (str == "" || str == null)
            return -1;

        // 统计每个字符出现的次数
        Map<Character, Integer> characters = new HashMap<>();

        for(int i = 0; i < str.length(); i ++) {
            characters.put(str.charAt(i), characters.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i ++) {
            if (characters.get(str.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "1232321342437";
        int res = FirstNotRepeatingChar(str);
        System.out.println(res);
    }
}
