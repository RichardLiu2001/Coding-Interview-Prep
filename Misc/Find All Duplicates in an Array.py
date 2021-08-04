class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:

        result = []

        for i, num in enumerate(nums):

            curr_num = abs(num)
            if nums[curr_num - 1] < 0:
                result.append(curr_num)
            else:
                nums[curr_num - 1] *= -1

        return result
