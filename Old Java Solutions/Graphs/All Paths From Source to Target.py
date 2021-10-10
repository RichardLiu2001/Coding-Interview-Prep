class Solution:

    def generatePathsDFS(self, currentPath, graph, current, dest, result):

        if current == dest:
            result.append(list(currentPath))
            return

        for neighbor in graph[current]:

            currentPath.append(neighbor)
            self.generatePathsDFS(currentPath, graph, neighbor, dest, result)
            currentPath.pop()




    def allPathsSourceTargetDFS(self, graph: List[List[int]]) -> List[List[int]]:
        
        if len(graph) == 0:
            return []

        result = []

        start = 0
        dest = len(graph) - 1

        currentPath = [0]

        self.generatePathsDFS(currentPath, graph, start, dest, result)

        return result


    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:

        paths = []
        if not graph or len(graph) == 0:
            return paths


        queue = deque()
        path = [0]
        queue.append(path)

        while queue:

            currentPath = queue[0]
            queue.popleft()

            node = currentPath[-1]

            for neighbor in graph[node]:

                temp_path = currentPath.copy()

                temp_path.append(neighbor)

                if neighbor == len(graph) - 1:
                    paths.append(temp_path)
                else:
                    queue.append(temp_path)

        return paths

