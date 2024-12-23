
/**
 * Leet Code question link:
 * https://leetcode.com/problems/meeting-rooms/description/
 * 
 * Given an array of intervals representingN appointments, find out if a person
 * can attend all the appointments.
 * 
 * Approach:
 * 1. Sort the intervals according to thier start time.
 * 2. Check if the current interval's start < previous interval's end.
 * 3. If true -> then person cannot attend the meeting add the pair as
 * conflicting interval.
 * 4. If flase -> person can attend. Keep iterating.
 */
import java.util.*;

class Solution {
    public List<List<int[]>> conflictingPair(int[][] appointments) {
        List<List<int[]>> result = new ArrayList<>();
        Arrays.sort(appointments, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < appointments.length; i++) {
            if (appointments[i][0] < appointments[i - 1][1]) {
                result.add(Arrays.asList(appointments[i - 1], appointments[i]));
                // return false preson cannot attend there is conflict
            }
        }
        return result;
    }
}