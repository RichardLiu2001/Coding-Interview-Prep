"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if not node:
            return None

        # maps old nodes to new (copied) nodes
        old_to_new = {}

        return self.cloneDFS(node, old_to_new)

    # Run DFS, making copies at each node. Track which nodes we've made copies of
    # so we can add them to copied nodes' neighbor lists.
    def cloneDFS(self, old_node, old_to_new):

        # If we've already cloned this node, return the clone (new node)
        if old_node in old_to_new:
            return old_to_new[old_node]

        # Create copy of old_node and add it to old_to_new
        # That way, in future recursive calls to copy other nodes, they will be able to
        # look up this copy (without a recursive call) and add it to their neighbors.
        new_node = Node(old_node.val, [])
        old_to_new[old_node] = new_node

        for neighbor_node in old_node.neighbors:

            cloned_neighbor = self.cloneDFS(neighbor_node, old_to_new)
            new_node.neighbors.append(cloned_neighbor)

        return new_node
