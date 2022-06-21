class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:

        kth_smallest_index = len(nums) - k

        return self.quickSelect(kthLargestIndex, nums, 0, len(nums) - 1)

    def quickSelect(self, , nums, l, r):

        pivot_separating_index = l
        # for simplicity, always choose rightmost value as the pivot
        # could randomly pick any value between l and r inclusive
        pivot = nums[r]

        # don't include r since it is the pivot
        for i in range(l, r):
            current_num = nums[i]

            if current_num <= pivot:

                nums[currentIndex], nums[i] = nums[i], nums[currentIndex]
                currentIndex += 1


        nums[currentIndex], nums[r] = nums[r], nums[currentIndex]

        if currentIndex > k:

            return self.quickSelect(k, nums, l, currentIndex - 1)

        if currentIndex < k:

            return self.quickSelect(k, nums, currentIndex + 1, r)

        # p == k
        return nums[currentIndex]


    def findKthLargestHeap(self, nums: List[int], k: int) -> int:
        
        heapq.heapify(nums)

        for _ in range(len(nums) - k):

            heapq.heappop(nums)

        return nums[0]

    ## Note: Quickselect algorithm could be useful