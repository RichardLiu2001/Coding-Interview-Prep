# responsible for storing the state of the game board
import numpy as np

DIRECTIONS = [[1, 0], [-1, 0], [0, 1], [0, -1], [-1, -1], [1, 1], [1, -1], [-1, 1]]
ROWS = 6
COLS = 7

class Board:

	def __init__(self):

		self.board = [['.' for i in range(COLS)] for j in range(ROWS)]

		# store the lowest empty slot for each column (the row the chip would end up falling to if it were
		# dropped in each column)
		self.drop_indices = [ROWS - 1 for i in range(COLS)]
		self.move_count = 0

	def is_valid_move(self, move_col):

		# check out of bounds
		if move_col < 1 or move_col > COLS:

			return False, 0

		# check if the column is full
		if self.board[0][move_col - 1] != '.':

			return False, 1

		return True, 0


	def make_move(self, move_col, player_color):

		self.move_count += 1

		# Reprocess player input move (1 based indexing) to board index (0 based)
		move_col -= 1
		
		dest_row = self.drop_indices[move_col]

		self.board[dest_row][move_col] = player_color

		self.drop_indices[move_col] -= 1

		return (player_color, dest_row, move_col)


	def check_result(self, move):

		player_color = move[0]
		move_row = move[1]
		move_col = move[2]

		for i in range(len(DIRECTIONS)):
			consecutive = 1
			dx = DIRECTIONS[i][0] 
			dy = DIRECTIONS[i][1]

			current_row = move_row + dx
			current_col = move_col + dy

			while self.in_bounds(current_row, current_col):

				if self.board[current_row][current_col] == player_color:
					consecutive += 1
				else:
					break

				if consecutive == 4:
					return player_color

				current_row += dx
				current_col += dy

		return 'D' if self.move_count == ROWS * COLS else 'P'


	def in_bounds(self, row, col):

		return row >= 0 and row < ROWS and col >= 0 and col < COLS


	def print_board(self):
		print(np.asarray(self.board))
