# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        max_diameter = [0]

        self.dfs_height(root, max_diameter)

        return max_diameter[0]

    # returns height of current node (in nodes, not edges) and updates max_diameter
    def dfs_height(self, node, max_diameter):

        if not node:
            return 0

        left_height = self.dfs_height(node.left, max_diameter)
        right_height = self.dfs_height(node.right, max_diameter)

        current_height = max(left_height, right_height) + 1
        
        # cuurent diameter of a tree is the sum of the longest path down its
        # left and right children
        # the overall max diameter must be of this structure (longest down left,
        # longest down right, parent), though the parent might not be the root.
        current_diameter = left_height + right_height

        max_diameter[0] = max(max_diameter[0], current_diameter)

        return current_height
        