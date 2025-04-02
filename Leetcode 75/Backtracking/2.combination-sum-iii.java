
/**
 * Leetcode question link :
 * https://leetcode.com/problems/combination-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use dfs to explore combinations of sum possible.
 * 2. We have three conditions a) range of number 1 to 9, b) number of
 * combinations = k, c) we cannot have repeat
 * 3. Start with 1 add it to currList (possible combination) call dfs with start
 * + 1 (next number). After this dfs is completed we have covered the case where
 * we are including this currNumber in our combination.
 * 4. Now we want to cover the case where we are not including the start, so
 * remove the currNumber from currList and call dfs with start + 1 again.
 * 5. After dfs is completed return the list
 * 
 */
import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currCom = new ArrayList<>();
    int combinationLen;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.combinationLen = k;
        dfs(1, n);
        return result;

    }

    public void dfs(int start, int target) {
        if (target == 0) {
            if (currCom.size() == this.combinationLen) {
                result.add(new ArrayList<>(currCom));
            }
            return;
        }

        if (start > 9 || start > target || currCom.size() >= this.combinationLen) {
            return;
        }

        currCom.add(start);
        dfs(start + 1, target - start);
        currCom.remove(currCom.size() - 1);
        dfs(start + 1, target);
    }
}