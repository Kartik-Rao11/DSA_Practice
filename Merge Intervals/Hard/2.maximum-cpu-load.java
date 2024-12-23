import java.util.ArrayList;

/**
 * We are given a list of jobs. Each job has a startTime, an endTime, and a CPU
 * load when it is running. Our goal is to find the Maximum CPU Load at any time
 * if all the jobs are running on the same machine.
 * 
 * Apporach:
 * 1. Sort the jobs on the basis of the starting time.
 * 2. Iterate through the intervals.
 * 3. check current's start <= previous.end then they can merge (jobs can run at
 * the same time). if true -> merge the interval to form new interval and add
 * their cpu load.
 * 4. once the iteration is complete. Iterate through the intervals again to
 * find the max cpu load from it.
 * 
 */
import java.util.*;

class Solution {
    public int maxCPULoad(int[][] jobs) {
        int maxCPULoad = Integer.MIN_VALUE;
        List<int[]> inters = new ArrayList<>();
        Collections.addAll(inters, jobs);
        for (int i = 1; i < jobs.length; i++) {
            int[] current = inters.get(i);
            int[] previous = inters.get(i - 1);
            if (current[0] <= previous[1]) {
                int cpuLoad = previous[2] + current[2];
                inters.set(i, new int[] { previous[0], Math.max(current[1], previous[1]), cpuLoad });
                inters.remove(i);
                i--;
            }
        }

        for (int[] interval : inters) {
            maxCPULoad = Math.max(maxCPULoad, interval[2]);
        }

        return maxCPULoad;
    }
}