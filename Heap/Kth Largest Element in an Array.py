class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:

        corresponding_smallest_index = len(nums) - k

        return self.quickSelect(corresponding_smallest_index, nums, 0, len(nums) - 1)


    def quickSelect(self, k, nums, l, r):

        pivot_index = self.partition(nums, l, r)

        if pivot_index > k:

            return self.quickSelect(k, nums, l, pivot_index - 1)

        if pivot_index < k:

            return self.quickSelect(k, nums, pivot_index + 1, r)

        # pivot_separating_index == k
        return nums[pivot_index]


    def partition(self, nums, l, r):

        # for simplicity, always choose rightmost value as the pivot
        # could randomly pick any value between l and r inclusive
        pivot = nums[r]
        
        # to the left of this index are < pivot, to the right are > pivot
        separating_index = l

        for i in range(l, r):

            if nums[i] <= pivot:

                nums[i], nums[separating_index] = nums[separating_index], nums[i]

                separating_index += 1

        nums[r], nums[separating_index] = nums[separating_index], nums[r]

        return separating_index


    def findKthLargestHeap(self, nums: List[int], k: int) -> int:
        
        heapq.heapify(nums)

        for _ in range(len(nums) - k):

            heapq.heappop(nums)

        return nums[0]