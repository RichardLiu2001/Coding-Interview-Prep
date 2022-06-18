# responsible for holding information about a certain player
# name 
# getting input for player's move




class Player:

	def __init__(self, symbol):

		# symbol is X or O

		if symbol != 'X' and symbol != 'O':
			raise Exception("Player's symbol must be X or O")

		self.symbol = symbol

	def get_move(self):

		return input("Player " + self.symbol + ", enter the square (1-9) to place an " + self.symbol + " :")
