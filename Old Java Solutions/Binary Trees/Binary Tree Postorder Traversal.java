class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderHelp(root, result);
        return result;

    }

    public void inOrderHelp(TreeNode n, List<Integer> result) {

    	if (n == null) {
    		return;
    	}

    	inOrderHelp(n.left, result);
    	inOrderHelp(n.right, result);
        result.add(n.val);

    }
}