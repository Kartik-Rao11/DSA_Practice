import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode question link : https://leetcode.com/problems/merge-intervals/
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                res.add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[] { start, end });
        return res.toArray(new int[0][]);
    }
}