package leetcode.dfs.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: 2019-06-08
 * Author: snowy
 * Leetcode 207 : Course Schedule
 * 拓扑排序
 * */

public class TPsort_CourseSchedule_207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] prelist = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i ++) {
            prelist[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < prerequisites.length; i ++) {
            prelist[prerequisites[i][1]].add(prerequisites[i][0]);
        }

//        for (int i = 0; i < prerequisites.length; i++){
//            prelist[prerequisites[i][1]].add(prerequisites[i][0]);
//        }

        boolean[] visit = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (!dfs(prelist, visit, i)){
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(ArrayList[] list, boolean[] visit, int pos){
        if (visit[pos]){
            return false;
        } else {
            visit[pos] = true;
        }
        for (int i = list[pos].size() - 1; i >= 0; i --){
            if (!dfs(list, visit, (int) list[pos].get(i))){
                return false;
            }
            list[pos].remove(i);
        }
        visit[pos] = false;
        return true;
    }

    // 广度优先搜索
    public static boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;

        // 存储度数为0的点
        Queue<Integer> queue = new LinkedList<>();

        int[] inDegree = new int[numCourses];           // 存储结点的出度
        for(int i = 0; i < prerequisites.length; i ++) {
            inDegree[prerequisites[i][0]] ++;
        }

        for(int i = 0; i < inDegree.length; i ++) {
            if(inDegree[i] == 0)            // 入度为0的结点进队
                queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();                // 弹出
            for(int i = 0; i < prerequisites.length; i ++) {
                if(node == prerequisites[i][1]) {           // 被该结点指向的结点的入度减1
                    inDegree[prerequisites[i][0]] --;
                    if(inDegree[prerequisites[i][0]] == 0)      // 入度是否为0， 为0则进队
                        queue.offer(prerequisites[i][0]);
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        int num = 6;
        int[][] prerequisites = {{1, 0}, {2, 1}, {4, 1}, {4, 2}, {3, 2}, {3, 4}, {5, 4}, {5, 3}};
        boolean res = canFinish_bfs(num, prerequisites);
        System.out.println(res);
    }
}
