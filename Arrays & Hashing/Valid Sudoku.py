class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # all nums in each row, col, and square must be unique
        rows = defaultdict(set) # maps each row index to a set of the numbers appearing in that row
        cols = defaultdict(set) # maps each col index to a set of the numbers appearing in that col
        squares = defaultdict(set) # map each square (i,j) for i, j < 3 to a set of nums appearing in that square

        for current_row in range(len(board)):

            for current_col in range(len(board[0])):

                current_num = board[current_row][current_col]

                if current_num == '.':
                    continue

                square = (current_row // 3, current_col // 3)

                if current_num in rows[current_row] or \
                    current_num in cols[current_col] or \
                    current_num in squares[square]:

                    return False

                rows[current_row].add(current_num)
                cols[current_col].add(current_num)
                squares[square].add(current_num)

        return True
