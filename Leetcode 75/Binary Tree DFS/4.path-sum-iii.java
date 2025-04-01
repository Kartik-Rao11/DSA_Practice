
/**
 * Leetcode question link: https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * We need to find the no paths that equal to targetSum. we can chose any node as starting node but it must go down.
 * Since starting node can be anywhere, we have two cases either add the node for target or ignore it. This lead to HashMap approach.
 * In hashmap we are storing the currNode val + runningSum (the sum of the path till now) as key and it's freq as value.
 * The idea is if runningSum - target exist the hashMap we have found a path. This covers the both the cases as discussed.
 * 
 * 1. Define HashMap with base case. Apply dfs on root node with targetSum, runningSum = 0 (incase of root).
 * 2. update the running sum with currNode.val, get the count of runningSum - target from the hashMap.
 * 3. Put the running sum in the hashMap with updated frequency
 * 4. Call the right and left subtree of the node using dfs, by passing the runningSum and hashMap to repeat the above 3 steps.
 * 5. Once node a is completely processed and we are now back tracking we need to remove the frequency of it's sum from the 
 * running sum as this node's path already been considered and we are moving to different to path 
 * 
 * Time complexity -> O(N)
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);
        return dfs(root, targetSum, 0, freq);
    }

    public int dfs(TreeNode node, int target, long runningSum, HashMap<Long, Integer> prefixSum) {
        if (node == null)
            return 0;
        runningSum += node.val;
        int count = prefixSum.getOrDefault(runningSum - target, 0);
        prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1);

        count += dfs(node.left, target, runningSum, prefixSum);
        count += dfs(node.right, target, runningSum, prefixSum);

        prefixSum.put(runningSum, prefixSum.get(runningSum) - 1);

        return count;

    }
}