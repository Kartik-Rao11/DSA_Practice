/**
 * Leetcode question link :
 * https://leetcode.com/problems/rotate-image/description/
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            reverse(row, 0, row.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}