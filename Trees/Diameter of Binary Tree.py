# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        if not root:
            return 0
        
        left_depth = self.maxDepthHelp(root.left)
        right_depth = self.maxDepthHelp(root.right)

        

    def maxDepthHelp(self, node, current_depth):

        if not node:
            return current_depth
        
        return max(self.maxDepthHelp(node.left, current_depth + 1), self.maxDepthHelp(node.right, current_depth + 1))