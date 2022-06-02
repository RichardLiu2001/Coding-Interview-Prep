# responsible for holding the state of the board itself
# determine valid moves (in bounds of the board, occupied squares)
# determine game over

class Board:

	def __init__(self):

		self.board = [['' for i in range(3)] for j in range(3)]


	def is_valid_move(self, move):

		if move < 1 or move > 9:

			return False

		row = move // 3 
		column = move % 3  

		if self.board[row][column] != '':
			# occupied already
			return False

		return True


	def make_move(self, move, player_symbol):

		row = move // 3 
		column = move % 3  

		if not self.is_valid_move(move):

			return False

		self.board[row][column] = player_symbol

	def check_result(self):

		return 'P'
		# return X, O, D, or P
	
	def print_board(self):

		print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in self.board]))