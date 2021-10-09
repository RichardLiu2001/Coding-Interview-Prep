# Number of Islands

Category: YouTube
Date: July 22, 2021
Difficulty: Medium
Done: Yes
No: 200
Type: DFS

## [Link](https://leetcode.com/problems/number-of-islands/)

## Problem Description

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return *the number of islands*.

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

**Example 1:**

```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

**Example 2:**

```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

```

**Constraints:**

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`

## Solution

```java
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
```

## Explanation

### General

Iterate through the array from top-left to bottom-right. Upon reaching an island (a '1'), clear the entire island - turn it and all of its adjacent '1's (if any) into 0's. Increment the counter. 

### Clearing the Islands

- DFS. Base cases are going out of bounds.
- Turn 1's into 0's.
- If the current element is 0, stop searching and return early.
- Call recursively on top, left, right, and bottom adjacent elements. (Must do all directions, since an island could extend to the bottom and left).