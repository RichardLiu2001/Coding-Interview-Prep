# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        is_balanced = [True]

        #self.dfs_height(root, is_balanced)
            
        #return is_balanced[0]
        
        return self.dfs_height_return_pair(root)[0]


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


        # returns pair (bool, int) isBalanced and height of subtree starting at node
    def dfs_height_return_pair(self, node):

        if not node:
            return (True, 0)

        left_balanced, left_height = self.dfs_height_return_pair(node.left)

        # return False as soon as we can, height no longer matters since 
        # the False will propagate up the recursion tree and is what we care about.
        if not left_balanced:
            return (False, -1)

        right_balanced, right_height = self.dfs_height_return_pair(node.right)

        if not right_balanced:
            return (False, -1)

        current_node_balanced = abs(left_height - right_height) <= 1

        current_height = max(left_height, right_height) + 1

        return (current_node_balanced, current_height)