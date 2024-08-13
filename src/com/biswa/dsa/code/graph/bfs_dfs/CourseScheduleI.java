package com.biswa.dsa.code.graph.bfs_dfs;

import java.util.Arrays;

//https://leetcode.com/problems/course-schedule/
public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] cons = new int[numCourses][numCourses];
        for (int[] c : cons) {
            Arrays.fill(c, 0);
        }
        boolean[] vis = new boolean[numCourses];
        Arrays.fill(vis, false);

        for (int[] d: prerequisites) {
            cons[d[0]][d[1]] = 1;
        }

        return false;
    }

//    public boolean hasCycle(int src, int[][] cons, boolean[] vis) {
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        q.offer(course);
//        vis[course] = true;
//        while (!q.isEmpty()) {
//            int c = q.poll();
//
//            for (int i = 0; i < numCourses; i++) {
//                if (cons[c][i] == 1) {
//                    if (vis[i]) return true;
//
//                    q.offer(i);
//                }
//            }
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        int[][] arr = {{1,0},{1,2},{3,1},{3,4}};
        System.out.println(new CourseScheduleI().canFinish(5, arr));
    }
}
