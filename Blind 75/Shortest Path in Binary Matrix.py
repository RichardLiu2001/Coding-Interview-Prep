class Solution:

    def in_bounds(self, x, y, n):
        return x >= 0 and y >= 0 and x < n and y < n


    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        dx = [-1, 0, 1, -1, 1, -1, 0, 1]
        dy = [-1, -1, -1, 0, 0, 1, 1, 1]
        if len(grid) == 0:
            return 0

        if len(grid) == 1:
            if grid[0][0] == 0:
                return 1
            return 0

        if grid[0][0] != 0 or grid[len(grid) - 1][len(grid) - 1] != 0:
            return -1

        # BFS, since it's an unweighted graph

        # visit starting node

        # add neighbors to queue

        # mark neighbors as visited


        visited = {(0, 0) : 1}

        queue = deque()

        queue.append((0, 0))

        while len(queue) > 0:

            current_node = queue.popleft()
            current_x = current_node[0]
            current_y = current_node[1]
            
            current_dist_from_start = visited[(current_x, current_y)]

            # iterate over neighbors
            # make sure inbounds, 0, not already visited

            for i in range(len(dx)):

                neighbor_x = current_x + dx[i]
                neighbor_y = current_y+ dy[i]


                if self.in_bounds(neighbor_x, neighbor_y, len(grid)) and (neighbor_x, neighbor_y) not in visited and grid[neighbor_x][neighbor_y] == 0:
                    
                    if neighbor_x == len(grid) - 1 and neighbor_y == len(grid) - 1:
                        return current_dist_from_start + 1

                    queue.append((neighbor_x, neighbor_y))
                    visited[(neighbor_x, neighbor_y)] = current_dist_from_start + 1

        
        if (len(grid) - 1, len(grid) - 1) in visited:
            return visited[(len(grid) - 1, len(grid) - 1)]
        
        return -1
        

