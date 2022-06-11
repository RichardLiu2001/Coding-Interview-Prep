class MaxHeapElement:

	def __init__(self, val):

		self.val = val

	# override less than
    def __lt__(self, other_element):

    	return self.val > other_element.val
