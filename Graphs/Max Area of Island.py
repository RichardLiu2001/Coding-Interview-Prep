class Solution:

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
            
        if not grid or not grid[0]:
            return 0

        max_area = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    current_island_area = self.findIslandArea(grid, i, j, 0)
                    max_area = max(max_area, current_island_area)

        return max_area


    def findIslandArea(self, grid, i, j, current_island_area):

        if not self.inBounds(i, j, grid):
            return 0

        if grid[i][j] == 0:
            return 0
        
        grid[i][j] = 0

        neighbor_area = 0

        for di in range(len(self.dx)):

            neighbor_area += self.findIslandArea(grid, i + self.dx[di], j + self.dy[di], current_island_area)

        # add 1 for current square
        return current_island_area + 1 + neighbor_area


    def inBounds(self, i, j, grid):

        return i >= 0 and j >= 0 and i < len(grid) and j < len(grid[0])
