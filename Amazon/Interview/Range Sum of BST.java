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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumHelp(root, low, high);
    }

    public int rangeSumHelp(TreeNode n, int low, int high) {

    	if (n == null) {
    		return 0;
    	}

    	int totalFromHere = 0;

    	int currentVal = n.val;

    	if (currentVal >= low && currentVal <= high) {
    		totalFromHere += currentVal;
    		totalFromHere += rangeSumHelp(n.right, low, high);
    		totalFromHere += rangeSumHelp(n.left, low, high);
    	}

    	if (currentVal < low) {
    		totalFromHere += rangeSumHelp(n.right, low, high);
    	}

    	if (currentVal > high) {
    		totalFromHere += rangeSumHelp(n.left, low, high);
    	}

    	return totalFromHere;


    }
}