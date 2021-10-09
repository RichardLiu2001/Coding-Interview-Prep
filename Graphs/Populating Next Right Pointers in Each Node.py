"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        if not root or not root.left or not root.right:
            return root

        queue = deque()

        queue.append(root.left)
        queue.append(root.right)

        while queue:

            nodes_in_layer = len(queue)

            for i in range(nodes_in_layer):

                current = queue.popleft()

                # not "last" (right most) node in layer
                if i < nodes_in_layer - 1:
                    current.next = queue[0]


                if current.left:
                    queue.append(current.left)
                    queue.append(current.right)


        return root
