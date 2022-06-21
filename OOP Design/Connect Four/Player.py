# responsible for holding information about a player
# responsible for directly interacting with player

class Player:

	def __init__(self, color):

		self.color = color


	def get_move(self):
		
		return input(self.color + " player, enter the column 1 - 7 that you would like to drop your chip.")