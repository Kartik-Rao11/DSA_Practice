/*
 * Leetcode Link : https://leetcode.com/problems/set-matrix-zeroes/description/
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isFirstRowZero = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                isFirstColZero = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isFirstRowZero)
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        if (isFirstColZero)
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }

    }
}