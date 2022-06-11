class Solution:

    def lastStoneWeight(self, stones: List[int]) -> int:
        
        # max heap to store weights of stones
        stone_weights = [MaxHeapElement(s) for s in stones]

        heapq.heapify(stone_weights)

        while len(stone_weights) >= 2:

            heaviest_stone_weight = heapq.heappop(stone_weights).stone_weight

            second_heaviest_stone_weight = heapq.heappop(stone_weights).stone_weight

            diff = heaviest_stone_weight - second_heaviest_stone_weight

            if diff > 0:

                heapq.heappush(MaxHeap(diff))


        if len(stone_weights) == 1:

            return stone_weights[0].stone_weight

        return 0

# wrapper for max heap, since python only implements min heap by default
class MaxHeapElement:

    def __init__(self, stone_weight):
        self.stone_weight = stone_weight

    # override less than function
    def __lt__(self, other_element):

        return self.stone_weight > other_element.stone_weight