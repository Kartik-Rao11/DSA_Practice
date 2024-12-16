
/**
 * To be reviwed
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < arr.length - 1 && arr[low - 1] >= arr[low]) {
            low++;
        }
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        int subMax = Integer.MIN_VALUE;
        int subMin = Integer.MAX_VALUE;

        for (int i = low; i < high; i++) {
            subMax = Math.max(arr[i], subMax);
            subMin = Math.min(arr[i], subMin);
        }

        while (low > 0 && arr[low - 1] > subMin) {
            low--;
        }

        while (high < arr.length - 1 && arr[high + 1] < subMax) {
            high++;
        }

        return high - low + 1;

    }
}