class BruteForceSolution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        
        board = [[0 for i in range(3)] for j in range(3)]

        # current player ids are 1 and -1 (so that we can switch easily by * -1)
        currentPlayerId = 1

        for move in moves:

            moveRow, moveCol = move[0], move[1]

            board[moveRow][moveCol] = currentPlayerId

            # only the player who just made a move could win the game

            onDiag = moveRow == moveCol

            # 0, 2
            # 1, 1
            # 2, 0
            onAntiDiag = moveRow + moveCol == 2

            if self.checkRow(board, currentPlayerId, moveRow) or self.checkCol(board, currentPlayerId, moveCol) or \
                (onDiag and self.checkDiag(board, currentPlayerId) or (onAntiDiag and self.checkAntiDiag(board, currentPlayerId))):

                return 'A' if currentPlayerId == 1 else 'B'

            currentPlayerId *= -1

        if len(moves) == 9:

            return 'Draw'

        return 'Pending'


    def checkRow(self, board, playerId, row):

        for col in range(3):

            if board[row][col] != playerId:
                return False

        return True

    def checkCol(self, board, playerId, col):

        for row in range(3):

            if board[row][col] != playerId:
                return False

        return True


    def checkDiag(self, board, playerId):

        for row in range(3):

            col = row
            if board[row][col] != playerId:
                return False

        return True

    def checkAntiDiag(self, board, playerId):

        for row in range(3):
            col = 3 - row - 1

            if board[row][col] != playerId:
                return False

        return True
