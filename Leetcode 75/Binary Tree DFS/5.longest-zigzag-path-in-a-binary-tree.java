/**
 * Leetcode question link :
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach :
 * 1. DFS-> Start with root node for every node there is two possibility either
 * to
 * go left first or right first and the direction of dfs on child nodes depend
 * on parent. We need to consider both the possibility to get the longest path.
 * 2. Start DFS with root node first with initial direction as left, another dfs
 * on node with initial direction.
 * 3. In DFS calls we need to check what direction did the parent of the node is
 * traversing. if it is left we process right node with increasing the length +
 * 1. And to consider the case -> current child node if moved in left as root
 * will give another zig-zag path call the left subtree with initial length as 1
 * coz we are consider it to be root node.
 * Do the same for right case as well.
 * 
 * Time complexity -> O(N)
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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return max;
    }

    public void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null)
            return;

        max = Math.max(max, length);

        if (isLeft) {
            dfs(node.right, length + 1, false);
            dfs(node.left, 1, true);
        } else {
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false);
        }
    }
}