import java.util.*;

/**
 * Leetcode question link :
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Approach:
 * 1. Use parentMap this will store key as child node and the its value as
 * parent node. Every node's key will give its parent node.
 * 2. Since we have p and q nodes to find LCA from we will iterate through the
 * root node depth wise and will keep adding the parent of the each node in
 * parentMap untill we have both p and q parent's in the map.
 * 3. Once we have parents for p and q in hashmap iterate through the parentMap
 * add every parent or ancestor of p in hashSet.
 * 4. Iterate through parentMap using q. Find the parent of q which is the
 * hashset of parent of p.
 * If they match that is our lowest common ancestor
 * 
 * Time complexity -> O(N)
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parentMap.put(root, null);
        stack.push(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {

            TreeNode node = stack.pop();
            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;

    }
}