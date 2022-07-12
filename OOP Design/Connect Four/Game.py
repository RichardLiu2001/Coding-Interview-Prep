from Board import Board
from Player import Player

class Game:

	def __init__(self):

		self.board = Board()
		self.p1 = Player('R')
		self.p2 = Player('B')


	def play(self):

		status = 'P'

		while status == 'P':

			p1_col = self.get_player_move(self.p1)
			p1_move = self.board.make_move(p1_col, self.p1.color)
			self.board.print_board()

			if self.board.check_result(p1_move) != 'P':
				break

			p2_col = self.get_player_move(self.p2)
			p2_move = self.board.make_move(p2_col, self.p2.color)
			self.board.print_board()

			status = self.board.check_result(p2_move)


		if status == 'D':

			print('The game ended in a draw.')

		else:

			print('Player ' + status + " wins!")


	def get_player_move(self, player):

		is_valid = False

		move = None

		while not is_valid:

			move = player.get_move()

			try:
				move = int(move)

				is_valid, code = self.board.is_valid_move(move)

				if not is_valid:
					print(str(move) + " is not a valid move.")
					if code == 0:
						print("The move must be a number between 1 and 9, inclusive")

					elif code == 1:
						print("Square " + str(move) + " is already occupied")

			except:
				print(str(move) + " is not a valid move.")

				print(move + " is not an integer.")

		return move


game = Game()

game.play()