from collections import deque

class Solution:
    
    def findValidPathDFS(self, graph, current, end, visited):

        if current == end:
            return True

        visited[current] = True

        destSet = graph[current]

        if end in destSet:
            return True

        for destVertex in destSet:

            if not visited[destVertex]:
                result = self.findValidPathDFS(graph, destVertex, end, visited)
                if result:
                    return True

        #visited[current] = False

        return False


    
    def findValidPathBFS(self, graph, start, end, visited):

        queue = deque()

        queue.append(start)

        while len(queue) > 0:
            
            current = queue.popleft()
            
            if visited[current]:
                continue
            
            if current == end:
                return True

            visited[current] = True

            destSet = graph[current]

            if end in destSet:
                    return True

            for dest in destSet:
                #if not visited[dest]: 
                queue.append(dest)

                    
        return False

        


    def validPath(self, n: int, edges: List[List[int]], start: int, end: int) -> bool:
            
            if len(edges) == 0:
                return True
            
            graph = {}

            for edge in edges:

                startVertex = edge[0]
                destVertex = edge[1]

                if startVertex not in graph:
                    graph[startVertex] = set()

                if destVertex not in graph:
                    graph[destVertex] = set()

                graph[startVertex].add(destVertex)
                graph[destVertex].add(startVertex)


            visited = {}
            for vertex in graph:

                visited[vertex] = False


            return self.findValidPathBFS(graph, start, end, visited)

            #return self.findValidPathDFS(graph, start, end, visited)



