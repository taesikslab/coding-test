package exercise.inflearnjava.stringandarray;

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

    private static int solve(Interval[] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(interval -> interval.end));
        int answer = 0;

        for (Interval interval : intervals) {
            while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval);
            answer = Math.max(answer, minHeap.size());
            System.out.println(minHeap);
        }

        return answer;
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

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
