
/**
 * Leet code question :
 * https://leetcode.com/problems/employee-free-time/description/
 * 
 * For K employees, we are given a list of intervals representing the working
 * hours of each employee. Our goal is to find out if there is a free interval
 * that is common to all employees. You can assume that each list of employee
 * working hours is sorted on the startTime.
 * 
 * Approach:
 * (free time -> gap between non overlapping intervals. gap between current
 * meeting's start and previou's end that is the free time of employee).
 * 1. Sort the array on the basis of start time. (if not sorted)
 * 2. Merge the intervals on the basis of current start <= previous's end.
 * 3. After merging, we will have those intervals in the list that are non
 * overlapping.
 * 4. Push the free time (previous end and current meeting start);
 *
 */
import java.util.*;

class Solution {
    public List<int[]> employeeFreeTime(int[][] schedules) {

        List<int[]> inters = new ArrayList<>();
        Arrays.sort(schedules, Comparator.comparingInt(a -> a[0]));
        int start = schedules[0][0];
        int end = schedules[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < schedules.length; i++) {
            int[] current = schedules[i];
            if (current[0] <= end) {
                end = Math.max(current[1], end);
            } else {
                inters.add(new int[] { start, end });
                start = current[0];
                end = current[1];
            }
        }
        inters.add(new int[] { start, end });
        for (int i = 1; i < inters.size(); i++) {
            res.add(new int[] { inters.get(i - 1)[1], inters.get(i)[0] });
        }
        return res;
    }
}