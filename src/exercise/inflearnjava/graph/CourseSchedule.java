package exercise.inflearnjava.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int course = 4;
        int[][] nums = {{1, 0},
                {2, 1},
                {3, 2}};

        int[][] nums2 = {{1, 0},
                {0, 1}};

        System.out.println(solve(course, nums));
        System.out.println(solve(2, nums2));
    }

    private static boolean solve(int courseNumber, int[][] nums) {
        if (courseNumber <= 0) {
            return false;
        }

        // 1. inDegree 배열, Queue
        Queue<Integer> queue = new LinkedList();
        int[] inDegree = new int[courseNumber];

        // 1-1 inDegree
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            inDegree[nums[i][1]]++;
        }

        // 1-2 큐에 넣는다, 3을 찾는다
        int inDegreeLength = inDegree.length;
        for (int i = 0; i < inDegreeLength; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        //
        while (!queue.isEmpty()) {
            int firstZeroVal = queue.poll(); // 3

            for (int i = 0; i < numsLength; i++) {
                if (firstZeroVal == nums[i][0]) {
                    inDegree[nums[i][1]]--;
                    if (inDegree[nums[i][1]] == 0) {
                        queue.offer(nums[i][1]);
                    }
                }
            }
        }

        for (int i = 0; i < inDegreeLength; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
    }
}
