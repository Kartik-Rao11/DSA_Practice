class Solution {
    public int removeDuplicates(int[] nums) {
        int nextNonDup = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[nextNonDup - 1] != nums[i]) {
                nums[nextNonDup] = nums[i];
                nextNonDup++;
            }
        }
        return nextNonDup;
    }
}