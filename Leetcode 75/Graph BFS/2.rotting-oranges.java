
/**
 * Leetcode question link :
 * https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * The intuition behind the solution is to use a Breadth-First Search (BFS)
 * approach, which is well-suited for problems involving levels or minutes
 * passing by as in this case. We can think of each minute as a level in a BFS
 * traversal.
 * 
 * The process begins by scanning the grid to do two things:
 * 
 * Identify and enqueue all the initially rotten oranges (cells with a value 2),
 * as these will be the starting points for the spread of rot, and
 * Count the amount of fresh oranges (cells with a value 1) because we need to
 * keep track of when no fresh oranges are left.
 * The solution proceeds in rounds, where each round represents one minute. In
 * each round, the solution:
 * 
 * Increments the time counter once for all rotten oranges that will affect
 * fresh ones in that minute.
 * Dequeues a location of a rotten orange and checks its 4-directional
 * neighbors.
 * If a neighbor is a fresh orange, it becomes rotten. We decrement the count of
 * fresh oranges and enqueue the new rotten orange's location for the next round
 * of processing.
 * If there are no more fresh oranges (cnt = 0), the BFS is complete, and the
 * time counter (ans) reflects the minimum number of minutes elapsed. If some
 * fresh oranges were never reached (and therefore cnt is not zero after the
 * BFS), it's impossible to rot all oranges, and the function returns -1.
 * 
 * Time Complexity -> O(M*N)
 * 
 */
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int mins = 0;
        int[] directions = { -1, 0, 1, 0, -1 };
        while (!queue.isEmpty() && freshOranges > 0) {
            mins++;
            for (int i = queue.size(); i > 0; i--) {

                int[] currPos = queue.poll();

                for (int l = 0; l < 4; l++) {
                    int nextRow = currPos[0] + directions[l];
                    int nextCol = currPos[1] + directions[l + 1];

                    if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount
                            && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        freshOranges--;
                        queue.offer(new int[] { nextRow, nextCol });

                    }
                }
            }
        }

        return freshOranges > 0 ? -1 : mins;
    }
}