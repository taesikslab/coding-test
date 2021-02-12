package exercise.inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }

    private static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
        for (int[] point : points) {
            queue.offer(point);
        }
        queue.forEach(p -> System.out.println(p[0] + " " + p[1]));

        int[][] answer = new int[k][2];
        int index= 0;
        while(index < k) {
            answer[index] = queue.poll();
            index++;
        }

        return answer;
    }
}
