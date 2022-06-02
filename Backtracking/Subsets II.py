class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        result = set()

        nums.sort()

        self.subsetsWithDupHelp(nums, 0, [], result)

        return list(result)


    def subsetsWithDupHelp(self, nums, currentIndex, currentSubset, result):

        if currentIndex == len(nums):
            result.append(currentSubset)

        else:

            currentNum = nums[currentIndex]

            