class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        heapq.heapify(nums)

        for _ in range(len(nums) - k):

            heapq.heappop(nums)

        return nums[0

    ## Note: Quickselect algorithm could be useful