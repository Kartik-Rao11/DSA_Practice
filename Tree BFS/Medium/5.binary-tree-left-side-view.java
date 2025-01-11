
/**
 * Given a binary tree, return an array containing nodes in its left view. 
 * The left view of a binary tree is the set of nodes visible when the tree is seen from the left side.
 */
import java.util.*;

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
    public List<Integer> LeftView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                // i == 0 means it is on left side
                if (i == 0) {
                    res.add(currNode.value);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return res;
    }
}