# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        
        # Question just asks for how many, can use a static int or list of length 1
        good_nodes = []

        self.goodNodesDFSHelp(root, float("-inf"), good_nodes)

        return len(good_nodes)


    def goodNodesDFSHelp(self, node, max_so_far, good_nodes):

        if not node:
            return

        if node.val >= max_so_far:

            good_nodes.append(node.val)

            max_so_far = node.val

        self.goodNodesDFSHelp(node.left, max_so_far, good_nodes)
        self.goodNodesDFSHelp(node.right, max_so_far, good_nodes)