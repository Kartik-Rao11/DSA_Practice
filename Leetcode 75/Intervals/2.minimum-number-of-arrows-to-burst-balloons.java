
/**
 * Leetcode question link :
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * We can conclude that for merging intervals or balloons whose start and end
 * are
 * merging they can be burst by one arrow only and everytime there is a new
 * interval or baloon whose start or end are not merging we need new arrow.
 * 1. Sort the array of balloon on the basis of end time.
 * 2. Initialize the arrow = 1. (minium we need)
 * 3. Get the first balloon and iterate over the next checking if start point of
 * the balloon is greater than currBalloon end -> if yes that means they are not
 * merging and hence we need new arrow.
 * 
 */
import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                arrows++;
                lastEnd = points[i][1];
            }
        }

        return arrows;

    }
}