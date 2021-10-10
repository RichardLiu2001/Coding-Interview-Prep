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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }

    public TreeNode invertTreeHelper(TreeNode n) {
    	if (n == null) {
    		return n;
    	}

    	TreeNode temp = n.left;
    	n.left = n.right;
    	n.right = temp;

    	invertTreeHelper(n.left);
    	invertTreeHelper(n.right);

    	return n; 


    }
}