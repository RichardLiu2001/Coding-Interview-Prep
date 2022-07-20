class Solution:

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        if not grid or not grid[0]:
            return -1

        # queue to store rotten oranges, as well as neighboring oranges that will rot in the next 
        # time interval
        queue = deque()

        minutes = 0
        fresh = 0

        # Add all initially rotten oranges to the queue, and update fresh count
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                current_square = grid[i][j]
                if current_square == 1:
                    fresh += 1
                elif current_square == 2:
                    queue.append((i, j))

        # Need to have fresh > 0 condition, otherwise we will have an extra iteration where the 
        # rotten oranges don't infect any fresh oranges because no fresh oranges are left.
        while queue and fresh > 0:
            # At this point, the oranges in the queue are the ones that will rot this time interval, aka "just" rotted
            just_rotted_count = len(queue)

            for i in range(just_rotted_count):

                newly_rotten_orange = queue.popleft()

                # Add neighbors of newly rotten orange to queue
                # unless they are already rotten
                infected_neighbors = self.addNeighbors(newly_rotten_orange, grid, queue)
                fresh -= infected_neighbors

            minutes += 1

        return minutes if fresh == 0 else -1

    # Adds the neighbors of the given square to the queue, unless they are already visited
    # Putting the oranges that will rot in the next time interval in the queue
    # Also, marks the neighbors as VISITED (do this when enqueuing, not dequeuing to prevent
    # the same node from being added to the queue more than once)
    # Returns the number of infected neighbors.
    def addNeighbors(self, newly_rotten_orange, grid, queue):

        infected_neighbors = 0

        for di in range(len(self.dx)):

            neighbor_i = newly_rotten_orange[0] + self.dx[di]
            neighbor_j = newly_rotten_orange[1] + self.dy[di]

            # Don't add the neighbor if it's out of bounds, already visited/rotten, or empty
            if not self.inBounds(neighbor_i, neighbor_j, grid) or grid[neighbor_i][neighbor_j] != 1:
                continue

            queue.append((neighbor_i, neighbor_j))
            grid[neighbor_i][neighbor_j] = 2
            infected_neighbors += 1

        return infected_neighbors


    def inBounds(self, i, j, grid):
        return i >= 0 and j >= 0 and i < len(grid) and j < len(grid[0])
