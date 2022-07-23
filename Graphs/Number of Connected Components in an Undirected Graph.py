class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:

        # Store the graph as a dictionary mapping nodes to their adjacency lists
        neighbors = defaultdict(list)

        for source, dest in edges:
            neighbors[source].append(dest)
            neighbors[dest].append(source)

        connected_components = 0
        visited = set()

        for node in range(n):

            if node in visited:
                continue

            # Haven't visited this node before, it is part of a new
            # unconnected component that we haven't visited before
            connected_components += 1
            self.dfs_and_mark_visited(node, neighbors, visited)

        return connected_components


    # Run DFS from current node and put all visited nodes into the visited set.
    def dfs_and_mark_visited(self, node, neighbors, visited):

        if node in visited:
            return

        visited.add(node)

        for neighbor in neighbors[node]:

            self.dfs_and_mark_visited(neighbor, neighbors, visited)