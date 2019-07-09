package leetcode.string.com;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.*;

/**
 * Time: 2019-07-01
 * Author: snowy
 * Leetcode 127:  Word Ladder
 * */

public class WordLadder_127 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        int length = beginWord.length();

        Map<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < wordList.size(); i ++) {
            String word = wordList.get(i);

            for(int j = 0; j < length; j ++) {
                String key = word.substring(0, j) + "*" + word.substring(j +1, length);     // 通用状态

                ArrayList<String> values = map.getOrDefault(key, new ArrayList<String>());            // 符合当前通用状态的单词列表

                values.add(word);       // 将该次添加到它所属的通用状态的单词列表中
                map.put(key, values);   // 将其放回到map中
            }
        }

        // BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();    // 记录单词是否已经被访问过了
        visited.put(beginWord, true);

        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();      // 当前词
            String word = pair.getKey();
            int value = pair.getValue();        // 当前所属的层次

            for(int i = 0; i < length; i ++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, length);

                for(String adjacentWord : map.getOrDefault(key, new ArrayList<>())) {
                    if(adjacentWord.equals(endWord))        // 如果找到了目标词则成功找到了
                        return value + 1;

                    if(!visited.containsKey(adjacentWord)) {        // 该词是否已经被访问过了
                        visited.put(adjacentWord, true);
                        queue.add(new Pair<>(adjacentWord, value + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);

        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
