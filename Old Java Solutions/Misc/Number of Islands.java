class Solution {

    // Iterate through array, for each 1, increment count and clear entire island
    
    public int numIslands(char[][] grid) {

        int count = 0;
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {

                if (grid[i][j] == '1') {
                    count ++;
                    clearIslands(grid, i, j);
                }

            }
        }

        return count;
    }

    public void clearIslands(char[][] grid, int currRow, int currCol) {

        if (currRow >= grid.length || currCol >= grid[0].length || currRow < 0 || currCol < 0) {
            return;
        }

        if (grid[currRow][currCol] == '1') {
            grid[currRow][currCol] = '0';
        } else {
            return;
        }

        clearIslands(grid, currRow + 1, currCol);
        clearIslands(grid, currRow, currCol + 1);
        clearIslands(grid, currRow - 1, currCol);
        clearIslands(grid, currRow, currCol - 1);

    }
}