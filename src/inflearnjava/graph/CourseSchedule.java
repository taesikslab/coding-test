package inflearnjava.graph;

import java.util.Arrays;
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
    }

    private static boolean solve(int course, int[][] nums) {

        // 1. inDegree 배열, Queue
        Queue<Integer> queue = new LinkedList();
        int[] inDegree = new int[course];

        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            inDegree[nums[i][1]]++;
        }
        System.out.println(Arrays.toString(inDegree));

        // 2.queue에 0인 값 찾아서 넣기
        int inDegreeLength = inDegree.length;
        for (int i = 0; i < inDegreeLength; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // 3.
        while (!queue.isEmpty()) {
            int firstZero = queue.poll();

            for (int i = 0; i < numsLength; i++) {
                if (firstZero == nums[i][0]) {
                    inDegree[nums[i][1]]--;
                    if(inDegree[nums[i][1]] == 0) {
                        queue.offer(nums[i][1]);
                    }
                }
            }
        }

        // 4.
        for (int i = 0; i < inDegreeLength; i++) {
            if (inDegree[i] != 0) return false;
        }

        return true;
    }
}
