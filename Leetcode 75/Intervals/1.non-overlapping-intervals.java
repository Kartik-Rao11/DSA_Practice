
/**
 * Leetcode question link :
 * https://leetcode.com/problems/non-overlapping-intervals/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Sort the intervals on the basis of the end time.
 * 2. Get the first interval endTime.
 * 3. Now for the rest of intervals check if any of the start is < last
 * intervals endTime.
 * if yes-> they are can be merged or just increase the count of merged
 * intervals
 * if start > endTime -> they do not merge so update the endTime to this
 * interval's last time for next intervals checking
 * 
 * Time complexity -> O(logn) for sorting and or iterating over them O(N) ->
 * O(NlogN)
 * 
 */
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                count++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return count;

    }
}