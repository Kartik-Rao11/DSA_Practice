/**
 * Leetcode question link :
 * https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * The Tribonacci sequence is a generalization of the Fibonacci sequence where
 * each term is the sum of the three preceding ones. The sequence starts with
 * T(0) = 0, T(1) = 1, and T(2) = 1. The next terms are calculated as follows:
 * T(n) = T(n-1) + T(n-2) + T(n-3) for n > 2.
 */

class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 2 || n == 1)
            return 1;

        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            int next = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = next;
        }

        return t2;
    }
}