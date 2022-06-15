class MedianFinder:

    def __init__(self):

        self.small = [] # max heap storing all elements < median
        self.large = [] # min heap storing all elements > median

    def addNum(self, num: int) -> None:
        
        heapq.heappush(num, self.small)

        # if size mismatch, transfer largest to other heap

        # if median check fail, 

        if len(self.small) > len(self.large) + 1:

            largest_less_than_med = heapq.heappop(self.small)
            heapq.heappush(self.large, largest_less_than_med)

        if len(self.large) > len(self.small) + 1:

            smallest_greater_than_med = heapq.heappop(self.large)
            heapq.heappush(self.small, smallest_greater_than_med)

        


    def findMedian(self) -> float:
        








# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()