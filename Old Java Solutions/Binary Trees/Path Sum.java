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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) {
    		return false; 
    	}

        return hasPathSumHelp(root, sum);
    }

    public boolean hasPathSumHelp(TreeNode n, int sum) {

    	// if fallen out of tree
    	if (n == null) {
    		return false;
       	}

       	sum -= n.val;

       	if (n.left == null && n.right == null) {

       		return sum == 0;

       	}

    	return hasPathSumHelp(n.left, sum) || hasPathSumHelp(n.right, sum);

    }
}