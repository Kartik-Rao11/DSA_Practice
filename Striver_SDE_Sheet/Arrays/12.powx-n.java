/*
 * Leetcode question link : https://leetcode.com/problems/powx-n/description/
 */

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        long exp = n;
        if (n < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res *= x;
            }

            x *= x;
            exp /= 2;
        }

        return res;
    }
}