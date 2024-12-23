import java.util.ArrayList;
import java.util.List;

/**
 * Approach
 * 1. There are two possible cases in case of overlapping
 * a) 1'st list overlaps 2'nd
 * b) 2'nd list overlaps 1'st
 * 
 * 2. For both the case we need to get the overlapping interval i.e start and
 * end.
 * 3. To get the intersection for start we need Math.max(1stOverLappedStart,
 * 2ndOverLappedStart) and
 * for end we need Math.min(1stOverLappedEnd,2ndOverLappedEnd)
 */
class Solution {

    public List<int[]> findInterSection(int[][] firstInterval, int[][] secondInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstInterval.length && j < secondInterval.length) {

            boolean firstOverlapSecond = firstInterval[i][0] >= secondInterval[j][0]
                    && firstInterval[i][0] <= secondInterval[j][1];
            boolean secondOverlapFirst = secondInterval[j][0] >= firstInterval[i][0]
                    && secondInterval[j][0] <= firstInterval[i][1];

            if (firstOverlapSecond || secondOverlapFirst) {
                int start = Math.max(firstInterval[i][0], secondInterval[j][0]);
                int end = Math.min(firstInterval[i][1], secondInterval[i][1]);
                res.add(new int[] { start, end });
            }

            if (firstOverlapSecond) {
                i++;
            } else {
                j++;
            }

        }
        return res;
    }
}