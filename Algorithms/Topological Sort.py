from Graph import Graph

def topological_sort(g: Graph):

	# Stores the nodes that we have verified have no cycles from them if you run DFS starting at 
	# that node.
	verified = set()

	# An ordering of the nodes in the graph such that for every edge u→v, u comes before v in the ordering.
	topological_ordering = []

	for node in list(g.graph):

		if contains_cycle_dfs(node, set(), verified, topological_ordering, g):
			return -1

	# Reverse the order, since DFS added the nodes to the array from deepest to shallowest.
	return topological_ordering[::-1]


# Runs DFS from a node and checks if there is a cycle. 
def contains_cycle_dfs(node, current_path, verified, topological_ordering, g):

	# If the node is in the current path that we're searching, we've found a cycle.
	if node in current_path:
		return True

	# If we've already checked this node has no cycles in another DFS, we don't need to check again.
	if node in verified:
		return False

	current_path.add(node)

	# for neighbor in graph[node]:
	for neighbor in g.graph[node]:
		if contains_cycle_dfs(neighbor, current_path, verified, topological_ordering, g):
			return True

	verified.add(node)

	topological_ordering.append(node)

	return False


g = Graph(6)
g.add_edge(5, 2)
g.add_edge(5, 0)
g.add_edge(4, 0)
g.add_edge(4, 1)
g.add_edge(2, 3)
g.add_edge(3, 1)

result = topological_sort(g)
print(result)