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

		#self.p1_turn = True


	def get_player_move(self, player):

		move = player.get_move()

		while not self.board.is_valid_move(move):

			print(str(move) + " is not a valid move. Your move must be a number 1 - 9 inclusive.")
			move = player.get_move()

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

