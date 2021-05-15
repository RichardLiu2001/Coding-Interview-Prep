/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        boolean iterative = true;
        if (iterative) {
            preOrderIterative(stack, result, root);
            return result;
        }
        preOrderHelp(result, root);
        return result;
    }

    // recursive solution
    public void preOrderHelp(List<Integer> result, TreeNode n) {
    	if (n == null) {
    		return;
    	}

    	result.add(n.val);
    	preOrderHelp(result, n.left);
    	preOrderHelp(result, n.right);

    }

    // iterative solution
    public void preOrderIterative(LinkedList<TreeNode> stack, ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }



    }



}