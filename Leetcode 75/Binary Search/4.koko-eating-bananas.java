/**
 * Leetcode question link :
 * https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * Intution-> We need to find minimum eating speed bananas k in h hour for the
 * piles of bananas. With the minimum eating speed all the piles of bananas
 * should be finished. So our speed ranges from 0 to the max(piles) because in
 * worst case max pile should take max speed. With these speed ranges we can
 * apply binary search on these range and check if it statisfy the hour
 * condition or not.
 * 
 * Steps :
 * 1. Apply binary search on range 0 to max(piles).
 * 2. calculate mid (the possible speed) check if this mid could finish all the
 * piles in hours <= h (given).
 * If true then this mid could be possible ans or we could slow down more move
 * high to mid else increase eating speed so move low = mid + 1
 * return low
 * 
 * Time complexity -> for binary search O(log(max(piles))) and for checking if
 * koko can eat all bananas O(N) -> O(N log max(piles))
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = getMax(piles);

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canEatAll(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k);
        }
        return hours <= h;
    }
}