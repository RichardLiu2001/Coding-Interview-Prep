# responsible for holding the state of the board itself
# determine valid moves (in bounds of the board, occupied squares)
# determine game over

class Board:

	def __init__(self):

		self.board = [' ' for _ in range(9)]


	def is_valid_move(self, move):

		if move < 1 or move > 9:

			return False

		if self.board[move - 1] != ' ':
			# occupied already
			return False

		return True


	def make_move(self, move, player_symbol): 

		if not self.is_valid_move(move):

			return False

		self.board[move - 1] = player_symbol

	def check_result(self):

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
			