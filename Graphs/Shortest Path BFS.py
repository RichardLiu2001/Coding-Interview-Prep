def printShortestPath(adj, s, dest, vertex_count):

	pred = [0 for i in range(v)]
	dist = [0 for i in range(v)]

	if not BFS(adj, src, dest, vertex_count, pred, dist):
		print("No path between source and dest")


	path = []
	crawl = dest
	path.append(crawl)

	while pred[crawl] != -1:
		path.append(pred[crawl])
		crawl = pred[crawl]

	print("Length of shortest path is " : + str(dist[dest]))

	print("Shortest path: ")

	for i in range(len(path) -1, -1, -1):
		print(path[i], end = ' ')



def BFS(adj, src, dest, vertex_count, pred, dist):

	queue = deque()

	visited = [False for i in range(vertex_count)]

	for i in range(vertex_count):

		# stores the length of the shortest path from the source to this node
		dist[i] = 100000000

		# stores the node previous to this node in the shortest path
		pred[i] = -1


	visited[src] = True
	dist[src] = 0

	queue.append(src)

	while len(queue) != 0:
		current = queue[0]
		queue.popleft()

		for i in range(len(adj[current])):

			neighbor = adj[current][i]

			if not visited[neighbor]:
				visited[neighbor] = True
				dist[neighbor] = dist[current] + 1
				pred[neighbor] = current
				queue.append(neighbor)

				if neighbor == dest:
					return True


	return False

