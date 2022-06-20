class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:


    def quickSelect(self, nums, index, l, r):

        current_pointer = l 
        # for simplicity, always choose rightmost value as the pivot
        # could randomly pick any value between l and r inclusive
        pivot = nums[r]

        # don't include r since it is the pivot
        for i in range(l, r)
            current_num = nums[l]

            if current_num 



    def findKthLargestHeap(self, nums: List[int], k: int) -> int:
        
        heapq.heapify(nums)

        for _ in range(len(nums) - k):

            heapq.heappop(nums)

        return nums[0]

    ## Note: Quickselect algorithm could be useful