
/**
 * Leetcode Question link :
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use DFS to reach the leave from root. Keep saving the pair of currNode and maxTill now.
 * 2. Push the root node to the stack with currMax = Integer.MIN_VALUE, pop the Pair from the stack.
 * 3. Get the node and currMax, if node.val >= maxSoFar increase the count of good nodes.
 * 4. Update the nexMax either with currNode val or the maxValue that's been using.
 * 5. Push the right and left node pair with the update nexMax for next iteration
 * 
 * Time Complexity -> O(N)
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

class Pair<K, V> {
    K node;
    V max;

    Pair(K node, V max) {
        this.node = node;
        this.max = max;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        @SuppressWarnings("rawtypes")
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair<TreeNode, Integer>(root, Integer.MIN_VALUE));
        int count = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.node;
            int maxSoFar = p.max;

            if (node.val >= maxSoFar) {
                count++;
            }

            int newMax = Math.max(maxSoFar, node.val);
            if (node.right != null)
                stack.push(new Pair<TreeNode, Integer>(node.right, newMax));
            if (node.left != null)
                stack.push(new Pair<TreeNode, Integer>(node.left, newMax));
        }

        return count;

    }
}
