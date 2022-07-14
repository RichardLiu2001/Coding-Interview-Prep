class Solution:

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def numIslands(self, grid: List[List[str]]) -> int:
            
        if not grid or not grid[0]:
            return 0

        num_islands = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    num_islands += 1
                    self.dfsFill(grid, i, j)

        return num_islands

    def dfsFill(self, grid, i, j):

        if not self.inBounds(i, j, grid):
            return

        if grid[i][j] == '0':
            return
        
        grid[i][j] = '0'

        for di in range(len(self.dx)):

            self.dfsFill(grid, i + self.dx[di], j + self.dy[di])

    def inBounds(self, i, j, grid):

        return i >= 0 and j >= 0 and i < len(grid) and j < len(grid[0])
