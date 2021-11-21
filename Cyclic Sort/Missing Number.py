class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        n = len(nums)

        current_index = 0

        while current_index < n:

            current_number = nums[current_index]

            # if the current number is n, skip past it since it has no place to go in the array
            if current_number < n and current_number != nums[current_number]:

                nums[current_index], nums[current_number] = nums[current_number], nums[current_index]

            else:

                current_index += 1

        for i, num in enumerate(nums):

            # the first number who doesn't match its index
            if num != i:
                return i

        # if all of the numbers in the array are in the correct indices (sorted), then the 
        # only possible missing number is n, which would have appeared at index n, but the 
        # array only holds 0 ... n - 1
        return n