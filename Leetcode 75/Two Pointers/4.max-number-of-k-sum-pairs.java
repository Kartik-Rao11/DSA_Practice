import java.util.HashMap;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach (Two pointer):
 * 1. Use two Pointer one from start of the array other from end. Keep iterating
 * from both ends checking the if any sum of start + end = target. If the array
 * is sorted it is more efficient.
 * 
 * Time complexit -> O(N) (If array sorted already) else O(nlogn)
 * 
 * Approach (HashMap)
 * 1. Iterate over the array and use hashmap to store the (number - target) as
 * key and frequency of it.
 * 2. If there is a already key = num-target with frequency greater than 0 then
 * means we have reached the
 * target sum increment the operations count.
 * 
 * Time complexity -> O(N)
 * Space Complexity -> O(N)
 */

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int operations = 0;
        for (int num : nums) {
            int com = k - num;

            if (freq.getOrDefault(com, 0) > 0) {
                operations++;
                freq.put(com, freq.get(com) - 1);
            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

        }

        return operations;
    }
}