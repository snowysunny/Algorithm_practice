package leetcode.dfs.com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: 2019-06-08
 * Author: snowy
 * Leetcode 210: Course Schedule II
 * */

public class TPsort_CourseSchedule2_210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 1)
            return new int[0];

        int[] inDegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i ++) {
            inDegree[prerequisites[i][0]] ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++) {
            if(inDegree[i] == 0)
                queue.offer(i);
        }

        int[] res = new int[numCourses];
        int start = 0;

        while(!queue.isEmpty()) {
            int node = queue.peek();
            res[start ++] = queue.poll();
            for(int i = 0; i < prerequisites.length; i ++) {
                if(prerequisites[i][1] == node) {
                    inDegree[prerequisites[i][0]] --;
                    if(inDegree[prerequisites[i][0]] == 0)
                        queue.offer(prerequisites[i][0]);
                }
            }
        }

        return start == numCourses ? res : new int[0];
    }

//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        if(numCourses < 1)
//            return new int[0];
//
//        int[] inDegreen = new int[numCourses];
//        for(int i = 0; i < prerequisites.length; i ++)
//            inDegreen[prerequisites[i][0]] ++;
//
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i = 0; i < numCourses; i ++){
//            if(inDegreen[i] == 0)
//                queue.offer(i);
//        }
//
//        int start = 0;
//        int[] res = new int[numCourses];
//        while(!queue.isEmpty()) {
//            int node = queue.peek();
//            res[start ++] = queue.poll();
//
//            for(int i = 0; i <prerequisites.length; i ++) {
//                if(prerequisites[i][1] == node) {
//                    inDegreen[prerequisites[i][0]] --;
//                    if(inDegreen[prerequisites[i][0]] == 0)
//                        queue.offer(prerequisites[i][0]);
//                }
//            }
//        }
//
//        return start == numCourses ? res : new int[0];
//    }

    public static void main(String[] args) {
        int num = 6;
        int[][] prerequisites = {{1, 0}, {2, 1}, {4, 1}, {4, 2}, {3, 2}, {3, 4}, {5, 4}, {5, 3}};
        int[] res = findOrder(num, prerequisites);
        System.out.println(Arrays.toString(res));
    }
}
