package inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(15, 20);
        Interval i3 = new Interval(5, 10);
        Interval[] intervals = {i1, i2, i3};

        System.out.println(solve(intervals));
    }

    public static int solve(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a.end));
        int max = 0;

        for (Interval interval : intervals) {
            while (!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval);
            max = Math.max(max, minHeap.size());
        }

        return max;
    }

    public static void print(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start + " " + in.end);

        }
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            this.start = 0;
            this.end = 0;
        }

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
}