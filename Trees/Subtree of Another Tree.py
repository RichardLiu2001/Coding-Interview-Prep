# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        # If the subRoot is None, it is always a subtree. Either root is None (and thus the same tree),
        # or it has a node that has None as a child (any leaf). 
        if not subRoot:
            return True

        # A non-None subRoot cannot be a subtree of a None root.
        if not root:
            return False
        
        if self.isSameTree(root, subRoot):
            return True

        # Recursive call to check if subRoot is a subtree of any of the children of root.
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)


    # LC problem #100
    def isSameTree(self, root, subRoot):

        if not root and not subRoot:
            return True

        if not root or not subRoot:
            return False

        if root.val != subRoot.val:
            return False

        return self.isSameTree(root.left, subRoot.left) and self.isSameTree(root.right, subRoot.right)