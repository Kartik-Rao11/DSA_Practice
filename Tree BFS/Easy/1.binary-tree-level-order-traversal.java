
/**
 * Leetcode question :
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Given a binary tree, populate an array to represent its level-by-level
 * traversal. You should populate the values of all nodes of each level from
 * left to right in separate sub-arrays.
 * 
 * Approach:
 * BFS-> Go to a vertex explore all it's child -> then go to a child explore all
 * it's child
 *
 * 1. We want a level order traversal of tree.
 * 2. We will use a queue. Push the root node to the queue.
 * 3. We will Iterate the queue until is empty.
 * 4. Get the current size. This size will tell us how many child or more vertex
 * we need to explore.
 * 5. Loop till currentSize of the queue and whatever is at the top of the queue
 * that should be added in the ans as the level order.
 * 6. Explore the left and right child and add it into queue for next iteration.
 * 
 * Time complexity -> O(n) n-> is the number of the nodes
 */

import java.util.*;;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                // adding elements level by level
                currLevel.add(currNode.value);
                // explore the child and add to the queue for next iterations
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            result.add(currLevel);

        }

        return result;

    }
}