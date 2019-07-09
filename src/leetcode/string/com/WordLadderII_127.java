package leetcode.string.com;

import javafx.util.Pair;

import java.util.*;

/**
 * Time: 2019-07-01
 * Author: snowy
 * Leetcode 126: Word Ladder II
 * */

public class WordLadderII_127 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        int length = beginWord.length();

        Map<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i ++) {
            String word = wordList.get(i);

            for(int j = 0; j < length; j ++) {
                String key = word.substring(0, j) + "*" + word.substring(j + 1, length);        // 通用状态

                ArrayList<String> values = map.getOrDefault(key, new ArrayList<>());            // 符合当前通用状态的单词列表

                values.add(word);            // 将该次添加到它所属的通用状态的单词列表中
                map.put(key, values);       // 将其放回到map中
            }
        }

//        System.out.println(map);

        // BFS模块
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Map<String, List<List<String>>> path = new HashMap<>();

        queue.add(new Pair<>(beginWord, 1));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        list1.add(beginWord);
        list.add(list1);
        path.put(beginWord, new ArrayList<>(list));

        while(!queue.isEmpty()) {
//            System.out.println("Queue:" + queue + "path: " +  path);
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int value = pair.getValue();

            for(int i = 0; i < length; i ++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, length);


                for(String adjactWord : map.getOrDefault(key, new ArrayList<>())) {
                    List<List<String>> prePath = path.getOrDefault(word, new ArrayList<>());
                    if(!path.containsKey(adjactWord)) {             // 两种情况需要进行遍历，一是这个结点没有被访问过， 而是虽然这个结点已经被访问过了，但是还有其他的路径消耗相同的代价可以到达该节点
                        List<List<String>> curPath = new ArrayList<>();         // 作为记录当前结点的路径
                        for(List<String> onePath : prePath) {                   // 遍历获得当前结点
                            List<String> curonewPath = new ArrayList<>(onePath);
                            curonewPath.add(adjactWord);
                            curPath.add(curonewPath);
                        }
                        path.put(adjactWord, curPath);
                        queue.add(new Pair<>(adjactWord, value + 1));
                    } else if(path.get(adjactWord).get(0).size() == value + 1) {            // 消耗相同的代价到达该节点
                        List<List<String>> curPath = path.get(adjactWord);                  // 因为该节点之前已经被访问过了，所以需要获得之前得到的路径
                        for(List<String> onePath : prePath) {
                            List<String> curonewPath = new ArrayList<>(onePath);
                            curonewPath.add(adjactWord);
                            if(!curPath.contains(curonewPath))                              // 需要过滤掉重复的路径
                                curPath.add(curonewPath);
                        }
                        path.put(adjactWord, curPath);
//                        queue.add(new Pair<>(adjactWord, value + 1));         // 因为代价是相同的所以就不添加了吧，大大的节省了时间
                    }
                }
            }

        }

        return path.getOrDefault(endWord, new ArrayList<>());
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log"};
        List<String> wordList = Arrays.asList(words);

        List<List<String>> res = findLadders(beginWord, endWord, wordList);

        System.out.println(res);
    }

}
