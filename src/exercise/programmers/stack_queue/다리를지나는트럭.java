package exercise.programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        System.out.println(solution(2, 100, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> going = new LinkedList<>();
        Queue<Integer> done = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            waiting.offer(truck_weight);
        }

        while (!waiting.isEmpty() && !going.isEmpty()) {
            Integer cur = waiting.peek();
            int capacity = 0;
            for (int i = 0; i < bridge_length; i++) {
                if (capacity > weight) {
                    answer++;
                    continue;
                }
                going.offer(cur);
            }
            answer++;
        }


        return answer;
    }
}
