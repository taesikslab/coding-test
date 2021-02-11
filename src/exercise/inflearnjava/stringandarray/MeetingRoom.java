package exercise.inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

    public static void main(String[] args) {
        Interval in1 = new Interval(15, 20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);

        Interval[] intervals = {in1, in2, in3};

        System.out.println(solve(intervals));
    }

    private static boolean solve(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        System.out.println(Arrays.toString(intervals));

        for (int i = 0; i < intervals.length - 1; i++) {
            Interval current = intervals[i];
            Interval next = intervals[i + 1];
            if (current.end > next.start) return false;
        }

        return true;
    }

    private static class Interval {
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
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
