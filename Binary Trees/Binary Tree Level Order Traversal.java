class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public void helper(TreeNode node, int level, List<List<Integer>> levels) {

        // start the current level
        if (levels.size() == level) {   
            levels.add(new ArrayList<Integer>());
        }

         // fulfill the current level
        levels.get(level).add(node.val);

         // process child nodes for the next level
        if (node.left != null) {
            helper(node.left, level + 1, levels);
        }
        
        if (node.right != null) {
            helper(node.right, level + 1, levels);
        }
    }    


}