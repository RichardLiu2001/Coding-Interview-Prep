# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        right_most_nodes = []

        if not root:

            return right_most_nodes

        self.dfs(root, 0, result)

        return right_most_nodes


    def dfs(self, node, currentHeight, right_most_nodes):

        if not node:
            return

        # First time reaching this level
        if currentHeight == len(right_most_nodes):
            right_most_nodes.append(node.val)

        else:

            # Overwrite previous value; DFS goes left to right, so whatever
            # value we just found is farther to the right than the old value.
            right_most_nodes[currentHeight] = node.val

        # DFS traversal (preorder/postorder) works because they both go 
        # from left to right, thus the last value we reach at any level
        # is the rightmost, and we overwrite anything else we found before.
        self.dfs(node.left, currentHeight + 1, right_most_nodes)
        self.dfs(node.right, currentHeight + 1, right_most_nodes)


    def rightSideViewLevelOrderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        right_most_nodes = []

        if not root:
            return right_most_nodes

        queue = deque([root])

        while queue:
            
            # At this point, the queue holds all the nodes in a level.
            current_level_node_count = len(queue)

            # Rightmost node is the last node in the queue
            rightmost_node = queue[-1]
            right_most_nodes.append(rightmost_node.val)

            for _ in range(current_level_node_count):

                current_node = queue.popleft()

                # add left first to go left to right on each level
                if current_node.left:
                    queue.append(current_node.left)

                if current_node.right:
                    queue.append(current_node.right)

        return right_most_nodes