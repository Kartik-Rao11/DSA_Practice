/**
 * Leetcode question :
 * https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Use the concept of binary Search
 * Use two pointers low and high keep changing the values of high and mid
 * according to response of guess function.
 * If the guessed number is less than shift the low to mid + 1. Our search
 * sample space is shortened. if the guessed is more shift the high = mid -1
 * 
 */

class Solution {
    public int guessNumber(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

    int guess(int num) {
        /*
         * num -> the number you have guessed
         * 
         * @return -1 if num is higher than the picked number
         * 1 if num is lower than the picked number
         * otherwise return 0
         * int guess(int num);
         **/
        return 1;
    }
}   