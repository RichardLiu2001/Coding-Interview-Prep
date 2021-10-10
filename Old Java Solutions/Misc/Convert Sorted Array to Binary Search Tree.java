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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        
        return createSubTree(nums, 0, nums.length - 1);
            
    } 
    
    public TreeNode createSubTree(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= nums.length || leftIndex > rightIndex) {
            return null;
        }
        
        int middleIndex = (leftIndex + rightIndex) / 2;
        TreeNode n = new TreeNode(nums[middleIndex]);
        n.left = createSubTree(nums, leftIndex, middleIndex - 1);
        n.right = createSubTree(nums, middleIndex + 1, rightIndex);
        return n;
        
        
    }
}