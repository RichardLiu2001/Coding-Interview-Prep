class Solution {

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null) {
			return false;
		}

		if (isSameTree(s, t)) {
			return true;
		}

		return isSubtree(s.left, t) || isSubtree(s.right, t);

	}

	public boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return s == null && t == null;
		}

		if (s.val == t.val) {
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		}

		return false;
	}


}