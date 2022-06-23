# responsible for storing the state of the game board
import numpy as np

class Board:

	def __init__(self):

		self.board = [['.' for i in range(7)] for j in range(6)]

		# store the lowest empty slot for each column (the row the chip would end up falling to if it were
		# dropped in each column)
		self.drop_indices = [5 for i in range(7)]


	def is_valid_move(self, move_col):

		# check out of bounds
		if move_col < 1 or move_col > 7:

			return False, 0

		# check if the column is full
		if self.board[0][move_col - 1] != '.':

			return False, 1

		return True, 0


	def make_move(self, move_col, player_color):

		move_col -= 1
		
		dest_row = self.drop_indices[move_col]

		self.board[dest_row][move_col] = player_color

		self.drop_indices[move_col] -= 1


	def check_result(self, move):

		return 'P'


	def print_board(self):
		print(np.asarray(self.board))
