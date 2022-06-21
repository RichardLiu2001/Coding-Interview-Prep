class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:

        corresponding_smallest_index = len(nums) - k

        return self.quickSelect(corresponding_smallest_index, nums, 0, len(nums) - 1)

    def quickSelect(self, k, nums, l, r):

        # to the left of this index are < pivot, to the right are > pivot
        pivot_separating_index = l

        # for simplicity, always choose rightmost value as the pivot
        # could randomly pick any value between l and r inclusive
        pivot = nums[r]

        # don't include r since it is the pivot
        for i in range(l, r):
            current_num = nums[i]

            if current_num <= pivot:

                nums[pivot_separating_index], nums[i] = nums[i], nums[pivot_separating_index]
                pivot_separating_index += 1


        nums[pivot_separating_index], nums[r] = nums[r], nums[pivot_separating_index]

        if pivot_separating_index > k:

            return self.quickSelect(k, nums, l, pivot_separating_index - 1)

        if pivot_separating_index < k:

            return self.quickSelect(k, nums, pivot_separating_index + 1, r)

        # pivot_separating_index == k
        return nums[pivot_separating_index]


    def findKthLargestHeap(self, nums: List[int], k: int) -> int:
        
        heapq.heapify(nums)

        for _ in range(len(nums) - k):

            heapq.heappop(nums)

        return nums[0]