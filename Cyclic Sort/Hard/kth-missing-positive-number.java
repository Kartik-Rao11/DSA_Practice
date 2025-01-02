
/**
 * Leet code question link :
 * https://leetcode.com/problems/kth-missing-positive-number/
 * Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k.
 * 
 * Return the kth positive integer that is missing from this array. (another
 * variation -> return all the k postive numbers missing from the array )
 * 
 * Approach:
 * 1. Sort the array using Cyclic sort. Since the range is not in 1 to n. We can
 * ignore the number < 0 and numbers > array.length.
 * 2. After Sorting , iterate the array to find the numbers missing and push
 * them in to missing numbers array also keep track of the numbers that are out
 * of the place.
 * 3. check the size of the missing number array if it is equal to k that means
 * we have all the k postive numbers. if not then it means missing numbers lies
 * after the array.length + 1. Iterate the array while missing number array is
 * equal to k postive integers. Add the number in the missing array only if it
 * has'nt been visited earlier
 */
import java.util.*;

class Solution {
    public int findKthPositive(int[] nums, int k) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        List<Integer> missingNumber = new ArrayList<>();
        Set<Integer> numberVisited = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                if (missingNumber.size() < k) {
                    missingNumber.add(j + 1);
                    numberVisited.add(nums[i]);
                }
            }
        }
        int j = 1;
        while (missingNumber.size() < k) {
            int currNum = nums.length + 1;
            if (!numberVisited.contains(currNum)) {
                missingNumber.add(currNum);
            }
            j++;
        }

        // return kth postive number or return the whole array of missing number if
        // required
        return missingNumber.get(k - 1);

    }
}