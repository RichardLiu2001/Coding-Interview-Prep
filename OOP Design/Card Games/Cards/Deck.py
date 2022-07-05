from Card import Card
import random

class Deck:

	def __init__(self):

		self.deck = []

		for suit in Card.Suit:

			for rank in Card.ranks:

				self.deck.append(Card(suit, rank))


	def shuffle(self):
		random.shuffle(self.deck)

deck = Deck()
for card in deck.deck:
	print(card)
