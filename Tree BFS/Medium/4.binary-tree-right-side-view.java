
/**
 * Leetcode question :
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
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
    public List<Integer> rightView(TreeNode root) {
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
                // i == levelSize means it is on right side
                if (i == levelSize - 1) {
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