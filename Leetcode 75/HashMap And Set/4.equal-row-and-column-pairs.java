import java.util.*;
/**
 * Leetcode Question link:
 * https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * We need to compare rows with col. Use HashMap to store the row as key value
 * its frequencies
 * 1. Iterate over the matrix get the row convert it to the string add it to
 * hashMap as key.
 * 2. Now again iterate over the matrix now column wise get a whole col value
 * put it in the array and convert it to string and check it in hashMap if they
 * key exist and get its frequency. This will the number of matches of row and
 * col
 * 
 */

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> rowKey = new HashMap<>();
        int count = 0;

        for (int[] row : grid) {
            String currRow = Arrays.toString(row);
            rowKey.put(currRow, rowKey.getOrDefault(currRow, 0) + 1);
        }

        for (int col = 0; col < n; col++) {
            int[] colArr = new int[n];
            for (int row = 0; row < n; row++) {
                colArr[row] = grid[row][col];
            }
            String colKey = Arrays.toString(colArr);
            count += rowKey.getOrDefault(colKey, 0);
        }

        return count;
    }
}