import java.util.*;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use HashSet for both arrays set1 and set2. Add elements in them
 * respectively
 * 2. Iterate over array 1 checking if arr1[i] exist in set2 if no add it
 * result1
 * 3. Iterate over array 2 checking if arr2[i] exist in set1 if no add it
 * result2
 * 4. return the combined result 1 and result 2
 * 
 * Time Complexity -> O(N) 4 passes
 * 
 */

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1)
            set1.add(n);
        for (int n : nums2)
            set2.add(n);

        List<Integer> unique1 = new ArrayList<>();
        for (int n : set1) {
            if (!set2.contains(n)) {
                unique1.add(n);
            }
        }

        List<Integer> unique2 = new ArrayList<>();
        for (int n : set2) {
            if (!set1.contains(n)) {
                unique2.add(n);
            }
        }

        return Arrays.asList(unique1, unique2);
    }
}