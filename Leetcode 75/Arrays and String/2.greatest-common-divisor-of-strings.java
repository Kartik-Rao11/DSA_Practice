/**
 * Leetcode solution :
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Intution:
 * 
 * The key insight is that if there exists such a common string x that divides
 * both str1 and str2, then the concatenation of str1 with str2 (str1 + str2)
 * should be the same as the concatenation of str2 with str1 (str2 + str1). If
 * this condition doesn't hold, it implies there is no such common string and
 * the answer is an empty string.
 * 
 * Approach :
 * 1. Check for Compatibility -> This is facilitated by the operation if str1 +
 * str2 != str2 + str1, which ensures that the pattern of characters in both
 * strings is compatible for them to have a common divisor string.
 * 
 * 2. Find Length of the Common Divisor -> The greatest common number that can
 * divide both the strings gcd
 * 
 * Time Complexity -> For Concatenation of strings O(n + m) and gcd O(log min(n
 * + m)) where n and m are the length of the strings.
 * 
 * Total Time complexity -> O(n + m) + O(log min(n + m))
 * 
 */

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLen = gcd(str1.length(), str2.length());
        return str2.substring(0, gcdLen);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}