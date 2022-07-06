# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Recursive solution
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        # The list at levels[i] represents the nodes at that level.
        # The root is considered to be at level 0.
        levels = []

        self.levelOrderHelp(root, 0, levels)

        return levels


    def levelOrderHelp(self, node, current_level, levels):

        if not node:
            return

        if current_level == len(levels):

            levels.append([])

        levels[current_level].append(node.val)

        self.levelOrderHelp(node.left, current_level + 1, levels)
        self.levelOrderHelp(node.right, current_level + 1, levels)


    # Iterative solution
    def levelOrderIterative(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        result = []

        # Need this check because we automatically start with putting the 
        # root into the queue, which could be None.
        if not root:
            return result

        queue = [root]

        while queue:

            nodes_in_current_level = []

            # The number of nodes currently in the queue is how many there are in the
            # current level. 
            # This tells us how many nodes to pop for the current level. Once we pop all of
            # the nodes in the current level (and add their children), the queue will contain
            # just the children, corresponding to the next level.
            nodes_in_current_level_count = len(queue)

            for _ in range(nodes_in_current_level_count):

                current_node = queue.pop(0)

                nodes_in_current_level.append(current_node.val)

                if current_node.left != None:

                    queue.append(current_node.left)

                if current_node.right != None:

                    queue.append(current_node.right)

            result.append(nodes_in_current_level)

        return result
