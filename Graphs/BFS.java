

public static void BFS(Node n, int vertexCount) {

	boolean visited[] = new boolean[vertexCount];

	LinkedList<Integer> q = new Queue<>();

	visited[n] = true;

	while (!q.isEmpty()) {

		Node cur = q.remove();
		System.out.println("Visited " + cur);

		for (Node neighbor : cur.neigbors) {

			if (!visited[neighbor]) {
				visited[neighbor] = true;
				q.add(neighbor);
			}

		}

	}

}