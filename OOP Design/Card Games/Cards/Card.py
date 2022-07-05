from enum import Enum

class Card:

	class Suit(Enum):
		CLUBS = '\u2663'
		DIAMONDS = '\u2666'
		HEARTS = '\u2665'
		SPADES = '\u2660'

	suit_values = {
		Suit.CLUBS : 0,
		Suit.DIAMONDS : 1,
		Suit.HEARTS : 2,
		Suit.SPADES : 3
	}

	ranks = {
		'2' : 2,
		'3' : 3,
		'4' : 4,
		'5' : 5,
		'6' : 6,
		'7' : 7,
		'8' : 8,
		'9' : 9,
		'10': 10,
		'J' : 11,
		'Q' : 12,
		'K' : 13,
		'A' : 14
	}

	def __init__(self, suit, rank):

		self.suit = suit
		self.rank = rank

	def __str__(self):
		return f"{self.rank}{self.suit.value}"

	def __lt__(self, other):
		if self.rank == other.rank:
			return self.suit_values[self.suit] < other.suit_values[other.suit]
		else:
			return self.ranks[self.rank] < other.ranks[other.rank]

# c1 = Card(Card.Suit.SPADES, '3')
# c2 = Card(Card.Suit.DIAMONDS, '3')

# print(c1)
# print(c2)
# print(c1 < c2)