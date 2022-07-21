WALL = -1
GATE = 0
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

        visited = set()

        queue = deque()

        for i in range(len(rooms)):
            for j in range(len(rooms[0])):

                current_square = rooms[i][j]

                if current_square == GATE:
                    queue.append((i, j))
                    visited.add((i, j))

        current_distance = 0
        
        while queue:

            num_nodes_in_layer = len(queue)
            
            for _ in range(num_nodes_in_layer):

                current_node_i, current_node_j = queue.popleft()

                # Whenever we reach an empty room (only empty rooms will be in the queue), 
                # we have found it via the closest path, since we are running BFS from each 
                # gate with each edge having the same distance (1).
                # Conveniently, the current distance starts at 0, so this also works for the gates we first
                # put in the queue.
                rooms[current_node_i][current_node_j] = current_distance

                self.add_neighbors(current_node_i, current_node_j, rooms, queue)

            current_distance += 1


    def add_neighbors(self, i, j, rooms, queue):

        for di in range(len(dx)):

            new_i = i + dx[di]
            new_j = j + dy[di]
            
            if not self.in_bounds(new_i, new_j, rooms) or rooms[new_i][new_j] == WALL or (new_i, new_j) in visited:
                continue

            # The square is an empty room
            queue.append((new_i, new_j))
            visited.add((new_i, new_j))


    def in_bounds(self, i, j, rooms):
        return i >= 0 and j >= 0 and i < len(rooms) and j < len(rooms[0])
