from collections import defaultdict

class Graph:

	def __init__(self, num_vertices):
		self.graph = defaultdict(list)
		self.num_vertices = num_vertices

	def add_edge(self, source, dest):
		self.graph[source].append(dest)

# g = Graph()
# g.add_edge(1, 2)