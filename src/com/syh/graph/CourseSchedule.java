package com.syh.graph;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-9-8
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode-cn.com/problems/course-schedule/description/
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();

        int length = 2;
        int[][] prerequisites = new int[length][2];
        prerequisites[0] = new int[]{1,0};
        System.out.println(c.canFinish(length, prerequisites)); // true

        length = 2;
        prerequisites = new int[length][2];
        prerequisites[0] = new int[]{1,0};
        prerequisites[1] = new int[]{0,1};
        System.out.println(c.canFinish(length, prerequisites)); // false

        length = 8;
        prerequisites = new int[length][2];
        prerequisites[0] = new int[]{1,0};
        prerequisites[1] = new int[]{2,6};
        prerequisites[2] = new int[]{1,7};
        prerequisites[3] = new int[]{5,1};
        prerequisites[4] = new int[]{6,4};
        prerequisites[5] = new int[]{7,0};
        prerequisites[6] = new int[]{0,5};
        System.out.println(c.canFinish(length, prerequisites)); // false

        length = 8;
        prerequisites = new int[length][2];
        prerequisites[0] = new int[]{1,0};
        prerequisites[1] = new int[]{2,6};
        prerequisites[2] = new int[]{1,7};
        prerequisites[3] = new int[]{6,4};
        prerequisites[4] = new int[]{7,0};
        prerequisites[5] = new int[]{0,5};
        System.out.println(c.canFinish(length, prerequisites)); // true
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0){
            return true;
        }

        Stack<Integer> visiting = new Stack<Integer>();
        Stack<Integer> visited = new Stack<Integer>();
        for(int i=0; i<numCourses; i++){
            if(dfsCheckFail(prerequisites, i, visiting, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfsCheckFail(int[][] prerequisites, int courseNum,
                                 Stack<Integer> visiting, Stack<Integer> visited) {
        if(visiting.contains(courseNum)){
            return true;
        }
        if(visited.contains(courseNum)){
            return false;
        }

        visiting.push(courseNum);
        for(int i=0; i<prerequisites.length; i++){
            if(courseNum != prerequisites[i][1] || ( prerequisites[i][1]==0 && prerequisites[i][0]==0 )){
                continue;
            }

            if(dfsCheckFail(prerequisites, prerequisites[i][0], visiting, visited)){
                return true;
            }
        }
        visited.push(visiting.pop());
        return false;
    }


}
