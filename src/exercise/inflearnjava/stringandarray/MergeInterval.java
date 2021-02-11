package exercise.inflearnjava.stringandarray;

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

        System.out.println(merge(intervals));
    }

    private static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        System.out.println(intervals);

        List<Interval> answer = new ArrayList<>();

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (prev.end >= cur.start) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                answer.add(prev);
                prev = cur;
            }
        }

        if (!answer.contains(prev)) {
            answer.add(prev);
        }

        return answer;
    }

    public static class Interval {
        public int start;
        public int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
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
