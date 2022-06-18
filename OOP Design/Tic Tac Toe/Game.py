# responsible for the mechanics of playing the game 
# creating board, players
# running game
# displaying status of game (over, who won)
# coordinate players taking turns

from Board import Board
from Player import Player

class Game:

	def __init__(self):

		self.board = Board()
		self.p1 = Player('X')
		self.p2 = Player('O')


	def get_player_move(self, player):

		isValid = False

		move = None

		while not isValid:

			move = player.get_move()

			try:
				move = int(move)

				isValid, code = self.board.is_valid_move(move)

				if not isValid:
					print(str(move) + " is not a valid move.")
					if code == 0:
						print("The move must be a number between 1 and 9, inclusive")

					elif code == 1:
						print("Square " + str(move) + " is already occupied")

			except:
				print(str(move) + " is not a valid move.")

				print(move + " is not an integer.")

		return move


	def play(self):

		result = self.board.check_result()

		while result == 'P':

			# make move

			p1_move = self.get_player_move(self.p1)
			self.board.make_move(p1_move, self.p1.symbol)
			result = self.board.check_result()
			self.board.print_board()
			if result != 'P':
				break

			p2_move = self.get_player_move(self.p2)
			self.board.make_move(p2_move, self.p2.symbol)
			self.board.print_board()

			result = self.board.check_result()

		print("Game over!")
		if result == 'D':
			print("The game ended in a draw.")
		else:
			print("Player " + result + " wins!")

game = Game()
game.play()

