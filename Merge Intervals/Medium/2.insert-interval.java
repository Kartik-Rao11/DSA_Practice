import java.util.ArrayList;
import java.util.List;

/**
 * Approach
 * 1. Skip all the intervals where interval.end < newInterval.start. (coz it's
 * not possible to merge them).
 * 2. After skipping, we got the index where we need to insert the index.
 * 3. Now from the remaining interval, we need to check if interval.start <
 * newInterval.end, then they can mergre
 * 4. update the max and min start and end value
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

    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        result.add(new Interval(newInterval.start, newInterval.end));
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;

    }

    // another way

    public List<int[]> insertInterval(int[][] intervals, Interval newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval.start) {
            res.add(intervals[i]);
            // res.add(new int[] { intervals[i][1], intervals[i][0] });
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval.end) {
            newInterval.start = Math.min(intervals[i][0], newInterval.start);
            newInterval.end = Math.max(intervals[i][1], newInterval.end);
            i++;
        }

        res.add(new int[] { newInterval.start, newInterval.end });
        while (i < intervals.length) {
            // res.add(new int[] { intervals[i][0], intervals[i][1] });
            res.add(intervals[i]);
            i++;
        }
        return res;
    }

}