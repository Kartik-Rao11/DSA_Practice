
/** Leetcode question link
 * https://leetcode.com/problems/sort-colors/description/
 */
class Solution {

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {

            switch (nums[mid]) {
                case 0:
                    int temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    int temp2 = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp2;
                    high--;
                    break;
                    
                default:
                    break;
            }
        }
    }
}