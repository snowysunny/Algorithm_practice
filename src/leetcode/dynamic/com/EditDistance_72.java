package leetcode.dynamic.com;

/**
 * Time: 2019-06-09
 * Author: snowy
 * Leetcode 72: Edit Distance
 * 编辑距离
 * */

public class EditDistance_72 {
    public static int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null)
            return 0;
        if(word1 == null)
            return word2.length();
        if(word2 == null)
            return word1.length();

        int[][] distances = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i ++) {
            distances[i][0] = i;
        }

        for(int i = 0; i <= word2.length(); i ++) {
            distances[0][i] = i;
        }

        for(int i = 1; i <= word1.length(); i ++) {
            for(int j = 1; j <= word2.length(); j ++) {
                distances[i][j] = Math.min(distances[i - 1][j], distances[i][j - 1]) + 1;           // distances[i - 1][j] ：相当于增加操作, distances[i][j - 1]： 相当于删除操作
                int change = 1;
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    change = 0;

                distances[i][j] = Math.min(distances[i][j], distances[i-1][j-1] + change);          // distances[i-1][j-1]相当于替换操作， change用于记录操作是否需要增加1
            }
        }

        return distances[word1.length()][word2.length()];
    }

    public static void main(String[] args){
        String word1 = "intention";
        String word2 = "execution";
        int res = minDistance(word1, word2);
        System.out.println(res);
    }
}
