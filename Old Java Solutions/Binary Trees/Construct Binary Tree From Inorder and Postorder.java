class Solution {

	int post_idx;
	int[] postorder;
	int[] preorder;

	HashMap<Integer, Integer> idx_map = new HashMap<>();

	public TreeNode helper(int in_left, int in_right) {

		// if there are no elemnts to construct subtrees
		if (in_left > in_right) {
			return null;
		}

		// pick up post_idx element as a root
		int root_val = postorder[post_idx];
		TreeNode root = new TreeNode(root_val);

		// root splits inorder list into left and right subtree
		int index = idx_map.get(root_val);

		// recursion
		post_idx--;

		// build right subtree
		root.right = helper(index + 1, in_right);

		// build left subtree
		root.left = helper(0, index - 1);
		return root; 

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		this.inorder = inorder;

		// start from the last postorder element
		post_idx = postorder.length - 1;

		// build a hashmap value -> index
		for (int i = 0; i < inorder.length; i ++) {
			idx_map.put(inorder[i], i);
		}

		return helper(0, inorder.length - 1);


	}







}