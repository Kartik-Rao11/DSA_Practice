import java.util.Arrays;

class Solution {

    public int closestDiff(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int currDiff = target - (nums[i] + nums[start] + nums[end]);
                if (currDiff == 0) {
                    return target - currDiff;
                }

                // if (Math.abs(currDiff) < Math.abs(minDiff)) {
                //     minDiff = currDiff;
                // }

                if (currDiff > 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return target - minDiff;
    }
}