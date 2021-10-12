class Solution:

    def removeDuplicates(self, nums: List[int]) -> int:

        if len(nums) < 2:
            return len(nums)

        index_to_place = 1

        for fast_pointer in range(1, len(nums)):

            last_non_duplicate = nums[index_to_place - 1]

            if nums[fast_pointer] > last_non_duplicate:

                # no need to swap, we don't care about what's beyond the last 
                # index of non_duplicated numbers
                nums[index_to_place] = nums[fast_pointer]

                index_to_place += 1

        return index_to_place


    def removeDuplicatesRichard(self, nums: List[int]) -> int:
        
        if len(nums) < 2:
            return len(nums)

        # looks ahead to find the next non-duplicate
        fast_pointer = 0

        # tracks the index to where the last element of the actually distinct portion
        # of the array is
        actual_index = 0

        while fast_pointer < len(nums):

            # found the next non-duplicate
            if nums[fast_pointer] > nums[actual_index]:

                # swap with nums + 1
                actual_temp = nums[actual_index + 1]

                nums[actual_index + 1] = nums[fast_pointer]

                nums[fast_pointer] = actual_temp

                actual_index += 1

            fast_pointer += 1 

        return actual_index + 1




