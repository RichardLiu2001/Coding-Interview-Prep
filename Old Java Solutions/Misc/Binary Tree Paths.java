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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        pathHelp(root, "", result);
        return result;

    }


    public void pathHelp(TreeNode n, String currentPath, ArrayList<String> result) {

    	if (n == null) {
    		return;
    	}

    	int currentVal = n.val;

    	currentPath += currentVal;

    	// this is a leaf, add to list
    	if (n.left == null && n.right == null) {
    		result.add(currentPath);
    	}

    	currentPath += "->";

    	pathHelp(n.left, currentPath, result);
    	pathHelp(n.right, currentPath, result);


    }




}