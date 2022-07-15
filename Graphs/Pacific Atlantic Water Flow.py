class Solution:

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        if not heights or not heights[0]:
            return []

        #visited_from_pacific = set()

        visit_from_pacific = set()
        visit_from_atlantic = set()

        for i in range(len(heights)):
            self.oceanDFS(i, 0, -1, visit_from_pacific, heights)
            self.oceanDFS(i, len(heights[0]) - 1, -1, visit_from_atlantic, heights)

        for i in range(len(heights[0])):
            self.oceanDFS(0, i, -1, visit_from_pacific, heights)
            self.oceanDFS(len(heights) - 1, i, -1, visit_from_atlantic, heights)

        return list(visit_from_pacific.intersection(visit_from_atlantic))


    def oceanDFS(self, i, j, previous_height, visited_from_ocean, heights):
        
        if not self.inBounds(i, j, heights):
            return

        if (i, j) in visited_from_ocean:
            return

        current_height = heights[i][j]

        if current_height < previous_height:
            return

        visited_from_ocean.add((i, j))

        # can visit current square
        for di in range(len(self.dx)):

            self.oceanDFS(i + self.dx[di], j + self.dy[di], current_height, visited_from_ocean, heights)


    def inBounds(self, i, j, heights):

        return i >= 0 and j >= 0 and i < len(heights) and j < len(heights[0])