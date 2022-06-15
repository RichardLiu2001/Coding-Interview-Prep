class MedianFinder:

    def __init__(self):
        self.nums = []

    def addNum(self, num: int) -> None:
        
        if len(self.nums) == 0:
            self.nums.append(num)

        else:

            i = 0

            while i < len(self.nums) and num > self.nums[i]:

                i += 1

            self.nums.insert(i, num)

    def findMedian(self) -> float:
        
        if len(self.nums) == 0:
            raise Exception('No median?')


        if len(self.nums) % 2 == 1:
            
            return self.nums[len(self.nums) // 2]
        
        else:

            hi = len(self.nums) // 2
            lo = hi - 1

            return (self.nums[hi] + self.nums[lo]) / 2








# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()