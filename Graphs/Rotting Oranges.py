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

        # Add all initially rotten oranges to the queue
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                current_square = grid[i][j]
                if current_square == 2:
                    queue.append((i, j))

        while queue:
            # At this point, the oranges in the queue are the ones that will rot this time interval, aka "just" rotted
            just_rotted_count = len(queue)

            for i in range(just_rotted_count):

                newly_rotten_orange = queue.popleft()

                # Add neighbors of newly rotten orange to queue
                # unless they are already rotten
                self.addNeighbors(newly_rotten_orange, grid, queue)

            minutes += 1

        # Check to see if there are any isolated oranges that never rotted
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                current_square = grid[i][j]
                if current_square == 1:
                    return -1


        # Return minutes if there aren't any
        return minutes + 1

    # Adds the neighbors of the given square to the queue, unless they are already visited
    # Putting the oranges that will rot in the next time interval in the queue
    # Also, marks the neighbors as VISITED (do this when enqueuing, not dequeuing to prevent
    # the same node from being added to the queue more than once)
    def addNeighbors(self, newly_rotten_orange, grid, queue):

        for di in range(len(self.dx)):

            neighbor_i = newly_rotten_orange[0] + self.dx[di]
            neighbor_j = newly_rotten_orange[1] + self.dy[di]

            # Don't add the neighbor if it's out of bounds, already visited/rotten, or empty
            if not self.inBounds(neighbor_i, neighbor_j, grid) or grid[neighbor_i][neighbor_j] != 1:
                continue

            queue.append((neighbor_i, neighbor_j))
            grid[neighbor_i][neighbor_j] = 2

    def inBounds(self, i, j, grid):
        return i >= 0 and j >= 0 and i < len(grid) and j < len(grid[0])
