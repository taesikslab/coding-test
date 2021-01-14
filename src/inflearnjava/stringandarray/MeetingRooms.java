package inflearnjava.stringandarray;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

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

    static Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };

    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(15, 20);
        Interval i3 = new Interval(5, 10);
        Interval[] intervals = {i1, i2, i3};

        System.out.println(solve(intervals));
    }

    public static boolean solve(Interval[] intervals) {
        if (intervals == null) return false;
        Arrays.sort(intervals, Comp);
        print(intervals);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    public static void print(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start + " " + in.end);

        }
    }
}
