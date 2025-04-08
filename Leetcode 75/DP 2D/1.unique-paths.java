
/**
 * Leetcode question link: https://leetcode.com/problems/unique-paths/?envType=study-plan-v2&envId=leetcode-75
 *
 * This problem is a classic example of a combinatorial problem that can be solved using dynamic programming (DP).
 * The key insight for a DP solution is that the number of unique paths to reach a particular cell in the grid
 * is the sum of the unique paths to reach the cell directly above it and the cell to its left. This is because
 * the robot can only move down or right, so any path to a cell must come from one of these two adjacent cells.
 *
 * A recursive solution following this approach would involve a lot of repeated calculations. A better approach
 * is to use an iterative DP algorithm, which builds up the solution bottom-up and avoids
 * recomputation.
 */
import java.util.*;

class Solution {

  public int uniquePaths(int m, int n) {
    int[] pathCount = new int[n];

    Arrays.fill(pathCount, 1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        pathCount[j] += pathCount[j - 1];
      }
    }

    return pathCount[n - 1];
  }
}
