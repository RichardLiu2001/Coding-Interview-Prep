# responsible for holding the state of the board itself
# determine valid moves (in bounds of the board, occupied squares)
# determine game over

class Board:

	def __init__(self):

		self.board = [' ' for _ in range(9)]
		self.row_sums = [0, 0 ,0]
		self.col_sums = [0, 0, 0]
		self.diag_sum = 0
		self.anti_diag_sum = 0

		self.player_to_val = {'X': 1, 'O': -1}
		self.move_count = 0

		self.player_to_move = 1

	def move_to_coords(self, move):

		zero_index_move = move - 1

		row = zero_index_move // 3
		col = zero_index_move % 3

		return row, col


	def is_valid_move(self, move):

		if move < 1 or move > 9:

			return False, 0

		if self.board[move - 1] != ' ':
			# occupied already
			return False, 1

		return True, -1


	def make_move(self, move, player_symbol): 

		if not self.is_valid_move(move):

			return False

		self.board[move - 1] = player_symbol

		player_val = self.player_to_val[player_symbol]

		move_row, move_col = self.move_to_coords(move)

		self.row_sums[move_row] += player_val
		self.col_sums[move_col] += player_val

		if move_row == move_col:
			self.diag_sum += player_val

		if move_row + move_col == 2:
			self.anti_diag_sum += player_val

		self.move_count += 1

		self.player_to_move *= -1


	def check_result(self, move):

		move_row, move_col = self.move_to_coords(move)

		if abs(self.row_sums[move_row]) == 3 or abs(self.col_sums[move_col]) == 3 \
			or abs(self.diag_sum) == 3 or abs(self.anti_diag_sum) == 3:

			# player_to_move already got multiplied by -1 in make_move
			# the player who just moved is the inverse
			return 'X' if self.player_to_move == -1 else 'O' 

		if self.move_count == 9:
			return 'D'

		return 'P'
		# return X, O, D, or P
	
	def print_board(self):

		print("\n")
		print("\t     |     |")
		print("\t  {}  |  {}  |  {}".format(self.board[0], self.board[1], self.board[2]))
		print('\t_____|_____|_____')

		print("\t     |     |")
		print("\t  {}  |  {}  |  {}".format(self.board[3], self.board[4], self.board[5]))
		print('\t_____|_____|_____')

		print("\t     |     |")

		print("\t  {}  |  {}  |  {}".format(self.board[6], self.board[7], self.board[8]))
		print("\t     |     |")
		print("\n")
			