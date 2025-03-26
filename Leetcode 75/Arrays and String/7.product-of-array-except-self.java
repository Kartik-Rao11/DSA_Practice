/**
 * Leetcode question link :
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. For every index i get the prefix product as well as suffix product.
 * 2. Mulitply the suffix and prefix product. For every i the product of array
 * except it self will be the suffix[i] * prefix[i]
 * 
 * Time complexity -> O(n)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}