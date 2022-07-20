class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if not board or not board[0]:
            return

        ROWS, COLS = len(board), len(board[0])

        for i in range(ROWS):
            for j in range(COLS):
                current_square = board[i][j]
                # Find all edge squares that are O's
                if current_square == 'O' and self.is_edge_square(i, j, ROWS, COLS):
                    # Run DFS on the connected region and mark the region as unsurroundable ('U')
                    # We need to mark this as a different character to differentiate it from surroundable
                    # regions ('O') and to be able to differentiate it from X's when we put the unsurroundable
                    # region back to O's at the end.
                    self.dfs_mark_unsurroundable(i, j, board)

        for i in range(ROWS):
            for j in range(COLS):
                current_square = board[i][j]
                if current_square == 'O':
                    board[i][j] = 'X'
                elif current_square == 'U':
                    board[i][j] = 'O'


    def is_edge_square(self, i, j, ROWS, COLS):

        return i == 0 or i == ROWS - 1 or j == 0 or j == COLS - 1


    def dfs_mark_unsurroundable(self, i, j, board):

        if not self.in_bounds(i ,j, board):
            return

        current_square = board[i][j] 

        # Don't recurse on X or U
        if current_square != 'O':
            return

        # Current square is O
        # Mark as UNSURROUNDABLE
        board[i][j] = 'U'

        self.dfs_mark_unsurroundable(i + 1, j, board)
        self.dfs_mark_unsurroundable(i - 1, j, board)
        self.dfs_mark_unsurroundable(i, j + 1, board)
        self.dfs_mark_unsurroundable(i, j - 1, board)


    def in_bounds(self, i, j, board):
        return i >= 0 and j >= 0 and i < len(board) and j < len(board[0])