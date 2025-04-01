import java.util.*;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. Use bfs to DFS to go to leave nodes of the tree and collect it leaves in
 * array list. Do the same with another subtree as well.
 * 2. Compare the leave nodes if they are equal return true else false
 * 
 * Time Complexity -> O(N + M) N and M are nodes in subtree 1 and subtree 2
 */

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeaves(root1).equals(getLeaves(root2));
    }

    public List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return leaves;

    }
}
