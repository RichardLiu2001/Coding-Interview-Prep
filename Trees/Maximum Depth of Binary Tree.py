# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        
        return self.maxDepthHelp(root, 0)

    def maxDepthHelp(self, node, current_depth):

        if not node:
            return current_depth
        
        return max(self.maxDepthHelp(node.left, current_depth + 1), self.maxDepthHelp(node.right, current_depth + 1))

    def maxDepthNoHelper(self, root):

        if not root:
            return 0
        
        left_height = self.maxDepthNoHelper(root.left)
        right_height = self.maxDepthNoHelper(root.right)

        return max(left_height, right) + 1