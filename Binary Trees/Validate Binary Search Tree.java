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
    public boolean isValidBST(TreeNode root) {
     	return BSThelp(root, null, null);
    }

    public boolean BSThelp(TreeNode n, Integer lower, Integer upper) {
    	if (n == null) {
    		return true;
    	}
    	int val = n.val;
    	if (upper != null && val >= upper) {
    		return false;
    	}
    	if (lower != null && val <= lower) {
    		return false;
    	}

    	return BSThelp(n.left, lower, new Integer(val)) && BSThelp(n.right, new Integer(val), upper);


    }


}