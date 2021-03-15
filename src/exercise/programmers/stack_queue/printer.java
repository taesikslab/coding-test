package exercise.programmers.stack_queue;

import java.util.*;

public class printer {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        int[] result = new int[priorities.length];
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new AbstractMap.SimpleEntry<>(i, priorities[i]));
        }

        return result[location];
    }
}
