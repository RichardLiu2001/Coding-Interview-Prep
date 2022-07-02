# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        is_balanced = [True]

        self.dfs_height(root, is_balanced)
        
        return is_balanced[0]
    
    def dfs_height(self, node, is_balanced):

        if not is_balanced[0]:
            return -1

        if not node:
            return 0

        left_height = self.dfs_height(node.left, is_balanced)
        right_height = self.dfs_height(node.right, is_balanced)

        if abs(left_height - right_height) > 1:
            # not balanced
            is_balanced[0] = False

        current_height = max(left_height, right_height) + 1

        return current_height