/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepthHelp(root, 0);
    }

    public int maxDepthHelp(TreeNode n, int currentDepth) {
    	if (n == null) {
    		return currentDepth;
    	}

    	return Math.max(maxDepthHelp(n.left, currentDepth + 1), maxDepthHelp(n.right, currentDepth + 1));

    }
}