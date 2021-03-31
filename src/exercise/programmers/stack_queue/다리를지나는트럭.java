package exercise.programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        System.out.println(solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1})); // 19
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
        System.out.println(solution(100, 100, new int[]{10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }

        int end = bridge_length;
        int totalWeight = 0;
        Queue<Integer> moving = new LinkedList<>();
        while (!trucks.isEmpty()) {
            for (int i = 1; i <= bridge_length; i++) {
                if (moving.size() >= bridge_length) {
                    int arrive = moving.poll();
                    totalWeight -= arrive;
                }
                if (trucks.isEmpty()) {
                    break;
                }

                int nextTruckWeight = trucks.peek();
                if (totalWeight + nextTruckWeight > weight) {
                    moving.offer(0);
                } else {
                    totalWeight += nextTruckWeight;
                    moving.offer(trucks.poll());
                }
                end++;
            }
        }

        return end;
    }
}
