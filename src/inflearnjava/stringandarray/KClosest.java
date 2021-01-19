package inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        KClosest problem = new KClosest();

        System.out.println(Arrays.deepToString(problem.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }

    public int[][] kClosest(int[][] list, int K) {
        Comparator<int[]> comparator = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
            }
        };
        Queue<int[]> queue = new PriorityQueue<>(list.length, comparator);

        Queue<int[]> queueWithLambda = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        int[][] result = new int[K][2];
        int index = 0;

        for (int[] ints : list) {
            queue.offer(ints);
        }

        while (index < K) {
            result[index] = queue.poll();
            index++;
        }

        return result;
    }
}
