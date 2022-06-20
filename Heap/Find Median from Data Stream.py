class MedianFinder:

    def __init__(self):

        self.small = [] # max heap storing all elements < median
        self.large = [] # min heap storing all elements > median

    def addNum(self, num: int) -> None:

        # by default, add to the small heap
        heapq.heappush(self.small, -1 * num)

        # Since the two heaps start out following the median rule (both empty)
        # and they maintain the rule every time a number is added, then 
        # the currently added number (num) is the only one that could break the rule
        if self.small and self.large: 
            #max_in_small = self.small[0] * -1
            min_in_large = self.large[0]

            #if max_in_small > min_in_large:
            if num > min_in_large:
                heapq.heappop(self.small)
                heapq.heappush(self.large, num)

        # readjust sizes so that the heaps' sizes are within 1 element
        if len(self.small) > len(self.large) + 1:

            largest_less_than_med = heapq.heappop(self.small) * -1
            heapq.heappush(self.large, largest_less_than_med)

        if len(self.large) > len(self.small) + 1:

            smallest_greater_than_med = heapq.heappop(self.large)
            heapq.heappush(self.small, smallest_greater_than_med * -1)


    def findMedian(self) -> float:
        
        # if either heap is larger (1 element more) than the other,
        # the median is the top element in that heap.
        # Otherwise, the median is the average of the tops of each heap.
        if len(self.small) > len(self.large):

            return self.small[0] * -1
 
        if len(self.large) > len(self.small):

            return self.large[0]

        return (self.small[0] * -1 + self.large[0]) / 2



# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()