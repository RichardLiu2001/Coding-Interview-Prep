WALL = 0
GATE = -1
EMPTY_ROOM = 2147483647
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        if not rooms or not rooms[0]:
            return

        for i in range(len(rooms)):
            for j in range(len(room[0])):

                current_square = rooms[i][j]

                if current_square == GATE:

                    self.bfs_update_distances_from_gate((i, j), rooms)


    def bfs_update_distances_from_gate(self, gate, rooms):

        queue = deque()

        visited = set()
        visited.add(gate)

        # gate is a tuple (i, j)
        queue.append(gate)

        current_distance = 1

        while queue:

            current_frontier_size = len(queue)

            # Explore each square in the frontier
            for _ in range(current_frontier_size):
                
                current_square_i, current_square_j = queue.pop()
                current_square = rooms[current_square_i][current_square_j]

                if current_square == WALL or current_square == GATE:
                    continue

                # Current square is empty.
                # The value of the current square is the shortest distance found so far from
                # a gate to the current square. 
                # Update this with the current distance, if smaller.
                rooms[current_square_i][current_square_j] = min(current_square, current_distance)

                # visited.add((current_square_i, current_square_j))
                self.add_neighbors(current_square_i, current_square_j, rooms, visited)

            current_distance += 1


    def add_neighbors(self, i, j, rooms, visited, queue):
        
        for di in range(len(dx)):

            new_i = i + dx[di]
            new_j = j + dy[di]

            if not self.in_bounds(new_i, new_j, rooms) or (new_i, new_j) in visited:
                continue

            new_square = rooms[new_i][new_j]

            if new_square == WALL or new_square == GATE:
                continue

            # New square is an empty square
            queue.append((new_i, new_j))
            visited.add((new_i, new_j))
