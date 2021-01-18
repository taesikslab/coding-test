package inflearnjava.stringandarray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        Interval in1 = new Interval(1, 3);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(6, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        MergeInterval mergeInterval = new MergeInterval();
        print(mergeInterval.merge(intervals));
    }

    public static void print(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
        System.out.println("================================");
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;

        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> result = new ArrayList<>();

        Interval before = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
