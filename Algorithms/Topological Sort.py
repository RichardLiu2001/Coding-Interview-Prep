from Graph import Graph


def topological_sort(g: Graph):

	verified = set()

	topological_ordering = []

	for node in range(g.num_vertices):

		if contains_cycle_dfs(node, set(), verified, topological_ordering, g):
			return -1

	return topological_ordering[::-1]


def contains_cycle_dfs(node, current_path, verified, topological_ordering, g):
	if node in current_path:
		return True

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