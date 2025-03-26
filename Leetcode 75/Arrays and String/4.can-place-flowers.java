/**
 * Leetcode question Link :
 * https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. For every index check it's left or right to be empty.
 * leftEmpty = (i == 0 || arr[i-1] == 0)
 * rightEmpty = (i == arr.length-1 || arr[i + 1] == 0)
 * 
 * 2. Reduce the number of given plant if it becomes 0 return true else false
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {

                boolean isLeftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean isRightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }

        }

        return n <= 0;
    }
}