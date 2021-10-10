"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:

    def cloneDFS(self, currentNode, visited):

        if currentNode in visited:
            return visited[currentNode]

        clone_node = Node(currentNode.val, [])

        visited[currentNode] = clone_node

        for neighbor in currentNode.neighbors:
            clone_node.neighbors.append(self.cloneDFS(neighbor, visited))

        return clone_node


    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if not node:
            return None

        visited = {}

        return self.cloneDFS(node, visited)
