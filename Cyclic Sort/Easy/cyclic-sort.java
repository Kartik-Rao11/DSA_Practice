/**
 * Problem:
 * We are given an array containing n objects. Each object, when created, was
 * assigned a unique number from 1 to n based on their creation sequence. This
 * means that the object with sequence number 3 was created just before the
 * object with sequence number 4.
 * 
 * Write a function to sort the objects in-place on their creation sequence
 * number in O(n) and without any extra space.
 * 
 * Approach:
 * 1. Array contains the numbers in the range 1 to n only. so on sorting number
 * 1 will be at the 0th index, number 2 will be on 1st index and so on..
 * 
 * 2. We will use this to place the number at it's correct index. (as we know
 * correct index of any number should be on the number-1th index).
 * 
 * 3. So number at ith index is not equal to the number at index number[ith]-1.
 * Then we swap the number to place it to the correct index.
 *
 * Time Complexity -> O(n)
 * 
 * 
 */
class Solution {

    public int[] cyclicSort(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1; /// correct index of number nums[i] = 3, 3-1 = 2, 3 must be on 2nd index

            if (nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }
        return nums;

    }

}