
/**
 * Leetcode question link :
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * To solve this problem, we can use the Breadth-First Search (BFS) algorithm.
 * BFS is an ideal choice for this kind of problem because it explores all
 * possible paths level by level or, in this case, step by step from the
 * entrance. As a result, the first time it reaches an exit, it is guaranteed to
 * be the nearest one since BFS doesn't explore deeper paths until all paths of
 * the current depth are explored.
 * 
 * We initialize BFS from the entrance by marking it as visited (to avoid
 * revisiting) and then iteratively exploring all four adjacent cells. If an
 * adjacent cell is empty and within the maze bounds, we check if it's an exit.
 * If it's an exit, we immediately return the current step count since it's the
 * minimum. If it's not, we continue the BFS by adding the cell to the queue.
 * Importantly, as we enqueue a cell, we mark it with a wall to avoid revisiting
 * cells that are already considered, effectively reducing unnecessary
 * calculations.
 * 
 * If the BFS completes without finding an exit, we conclude that no path
 * exists, and we return -1, indicating failure to reach an exit.
 * Time complexity -> O(M*N)
 * 
 */
import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rowCount = maze.length;
        int colCount = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);

        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        int[] directions = { -1, 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            steps++;
            for (int count = queue.size(); count > 0; count--) {
                int[] currPos = queue.poll();

                for (int l = 0; l < 4; l++) {
                    int nextRow = currPos[0] + directions[l];
                    int nextCol = currPos[1] + directions[l + 1];

                    if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount
                            && maze[nextRow][nextCol] == '.') {

                        if (nextRow == 0 || nextRow == rowCount - 1 || nextCol == colCount - 1 || nextCol == 0) {
                            return steps;
                        }

                        queue.offer(new int[] { nextRow, nextCol });
                        maze[nextRow][nextCol] = '+';
                    }

                }
            }
        }

        return -1;

    }
}