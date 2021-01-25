package inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        KthLargest a = new KthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(a.solve(nums, k));
        System.out.println(a.solveByPQ(nums, k));
    }

    public int solve(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    public int solveByPQ(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}