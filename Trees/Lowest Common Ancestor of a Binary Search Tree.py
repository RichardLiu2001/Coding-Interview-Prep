# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        if not root:
            return None
        
        # both p and q exist in the left subtree of root
        if p.val < root.val and q.val < root.val:

            return self.lowestCommonAncestor(root.left, p, q)
        
        # both p and q exist in the right subtree of root
        if p.val > root.val and q.val > root.val:

            return self.lowestCommonAncestor(root.right, p, q)
        
        # root is in between p and q, thus p and q are in different subtrees and hence their lowest
        # common ancestor is root.
        # Remember, ALL nodes in the left subtree of root are less than root, and ALL nodes in the 
        # right subtree are greater than root.
        return root