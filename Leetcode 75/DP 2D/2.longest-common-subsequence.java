/**
 * LeetCode question link :
 * https://leetcode.com/problems/longest-common-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * The solution leverages Dynamic Programming (DP), a method for solving complex
 * problems by breaking them down into simpler subproblems. The idea is to build
 * up a solution using previously computed results for smaller problems.
 * 
 * To approach this, we create a 2D array, f, with dimensions (m+1) x (n+1),
 * where m and n are the lengths of text1 and text2, respectively. The value of
 * f[i][j] will hold the length of the longest common subsequence between the
 * first i characters of text1 and the first j characters of text2.
 * 
 * We iterate over both strings and fill this table based on the following
 * rules:
 * 
 * If the characters at the current position in both strings match, then the
 * longest common subsequence would be that of the previous characters of both
 * strings plus one (because we include this matching character).
 * If the characters do not match, we take the maximum of two possible cases:
 * Including one less character from text1 and the current number of characters
 * from text2.
 * Including the current number of characters from text1 and one less from
 * text2.
 * The final answer, the length of the longest common subsequence, will be the
 * value stored in f[m][n] after the entire table is filled.
 * 
 * Time complexity -> O(N * M)
 */

class Solution {

    // using 2D DP array
    public int longestCommonSubsequence2(String text1, String text2) {
        // Lengths of the input strings
        int length1 = text1.length();
        int length2 = text2.length();

        // Create a 2D array to store the lengths of longest common subsequences
        // for all subproblems, initialized with zero
        int[][] dp = new int[length1 + 1][length2 + 1];

        // Build the dp array from the bottom up
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                // If characters match, take diagonal value and add 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If characters do not match, take the maximum value from
                // the left (dp[i][j-1]) or above (dp[i-1][j])
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The bottom-right cell contains the length of the longest
        // common subsequence of text1 and text2
        return dp[length1][length2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}