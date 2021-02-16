package exercise.inflearnjava.stringandarray;

import java.util.*;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solve(nums, k));

        int[] nums2 = {3, 2, 1, 5, 6, 4};
        int k2 = 2;
        System.out.println(solveByPQ(nums2, k2));
    }

    private static int solve(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        return nums[nums.length - k];
    }

    private static int solveByPQ(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }

        System.out.println(queue.toString());
        return queue.peek();
    }
}
