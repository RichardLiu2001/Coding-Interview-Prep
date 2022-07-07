# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        return self.isValidBSTHelp(root, float("-inf"), float("inf"))
        

    def isValidBSTHelp(self, node, lower_bound, upper_bound):

        if not node:
            return True

        if node.val >= upper_bound or node.val <= lower_bound:
            return False

        # going to left: all children to the left must be < root
        # update upper bound to be the root value
        left_is_bst = self.isValidBSTHelp(node.left, lower_bound, node.val)

        if not left_is_bst:
            return False

        # going to right: all children to the right must be > root
        # update lower bound to root value
        right_is_bst = self.isValidBSTHelp(node.right, node.val, upper_bound)

        if not right_is_bst:
            return False

        return True