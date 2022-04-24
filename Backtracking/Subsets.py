class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        self.generateSubsets(0, nums, [], result)

        return result

    def generateSubsets(self, currentIndex, nums, currentSubset, result):

        if currentIndex == len(nums):
            result.append(currentSubset[:])
        else:

            # try without using number at current index
            self.generateSubsets(currentIndex + 1, nums, currentSubset, result)

            # try with number at current index
            currentSubset.append(nums[i])
            self.generateSubsets(currentIndex + 1, nums, currentSubset, result)
            
            # reset
            currentSubset.pop()