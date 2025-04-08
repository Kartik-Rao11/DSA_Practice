/**
 * Leetcode question link:
 * https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * This is a Dynamic Programming (DP) problem, where we want to find the minimum
 * number of operations required to convert word1 into word2 using:
 * 
 * Insertion → Insert a character into word1
 * 
 * Deletion → Remove a character from word1
 * 
 * Replacement → Replace a character in word1 with another
 * 
 * We can think of it as a grid-based transformation problem where:
 * 
 * word1 is represented row-wise.
 * 
 * word2 is represented column-wise.
 * 
 * We solve subproblems for every prefix of word1 and word2.
 * 
 * we construct a matrix f where each cell f[i][j] represents the minimum number
 * of operations to convert the first i characters of word1 into the first j
 * characters of word2. The first row (f[0][j]) is initialized with the sequence
 * 0, 1, 2, ..., n because if word1 is empty, the only option is to insert
 * characters into it, and the number of operations equals the number of
 * characters in word2. Similarly, the first column (f[i][0]) is 0, 1, 2, ..., m
 * because if word2 is empty, the only option is to delete characters from
 * word1.
 * 
 * The intuition for the recursive step is as follows:
 * 
 * If the current characters in word1 and word2 are equal (word1[i - 1] ==
 * word2[j - 1]), no operation is needed, and the number of operations will be
 * the same as it was for i - 1 and j - 1.
 * If they are not equal, we need to consider three possible operations:
 * Inserting (f[i][j - 1] + 1): We have matched up to j - 1 of word2, and then
 * by adding the j-th character of word2, we will match j characters. The number
 * of operations is one more than it took to match j - 1 characters.
 * Deleting (f[i - 1][j] + 1): If we remove the i-th character from word1, we
 * fall back to the subproblem of matching i - 1 characters of word1 with j
 * characters of word2, and again, this is one more operation than that
 * subproblem.
 * Replacing (f[i - 1][j - 1] + 1): Here, we change the i-th character of word1
 * to match the j-th character of word2. So, the number of operations is one
 * more than the operations needed for i - 1 and j - 1.
 * We take the minimum of these three options at each step, and the last cell
 * f[m][n] will give us the minimum number of operations required to transform
 * word1 into word2.
 */

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return word1.length() != 0 ? word1.length() : word2.length();
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }

        return dp[m][n];
    }
}