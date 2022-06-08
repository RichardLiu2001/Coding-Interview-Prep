class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        
        result = []

        empty_board = self.createEmptyBoard(n)

        self.solveNQueensHelp(0, set(), set(), set(), empty_board, result, n)

        return result


    def createEmptyBoard(self, n):

        return [['.' for i in range(n)] for j in range(n)] 


    def formatSolution(self, board):
        result = []

        for row in board:

            result.append("".join(row))

        return result


    def solveNQueensHelp(self, currentRow, usedCols, usedDiagonals, usedAntiDiagonals, currentBoard, result, n):

        if currentRow == n:

            result.append(self.formatSolution(currentBoard))

        # try all columns in the current row
        for currentCol in range(n):

            # all squares on the same diagonal will have the same value
            currentDiagonal = currentRow - currentCol 
            
            # all squares on the same anti diagonal will have the same value
            currentAntiDiagonal = currentRow + currentCol

            # check if this column is attacked by another already placed queen, skip if so
            if currentCol in usedCols or currentDiagonal in usedDiagonals or currentAntiDiagonal in usedAntiDiagonals:
                continue

            # place queen
            currentBoard[currentRow][currentCol] = 'Q'

            usedCols.add(currentCol)
            usedDiagonals.add(currentDiagonal)
            usedAntiDiagonals.add(currentAntiDiagonal)

            self.solveNQueensHelp(currentRow + 1, usedCols, usedDiagonals, usedAntiDiagonals, currentBoard, result, n)

            # undo choice
            currentBoard[currentRow][currentCol] = '.'
            usedCols.remove(currentCol)
            usedDiagonals.remove(currentDiagonal)
            usedAntiDiagonals.remove(currentAntiDiagonal)
