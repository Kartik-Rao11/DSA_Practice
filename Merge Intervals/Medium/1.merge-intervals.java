import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Approach
 * Given = [start,end] = Interval
 * 1. Sort the Interval using their start time.
 * 2. For every interval we need to check if current Interval's start <=
 * previous end. Then they can be merged.
 * 3. Else just add the list into the mergeInterval and update the previous's
 * start and end.
 */
class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }

    // Another way with input intervals as int[][] interval

    public List<int[]> mergeInLine(int[][] intervals) {
        if (intervals.length < 2) {
            List<int[]> result = new ArrayList<>();
            Collections.addAll(result, intervals);
            return result;
        }

        List<int[]> inters = new ArrayList<>();
        Collections.addAll(inters, intervals);

        for (int i = 1; i < inters.size(); i++) {

            int[] current = inters.get(i);
            int[] previous = inters.get(i - 1);
            if (current[0] <= previous[1]) {
                inters.set(i, new int[] { previous[0], Math.max(previous[1], current[1]) });
                inters.remove(i - 1);
                i--;
            }
        }

        return inters;

    }
}
