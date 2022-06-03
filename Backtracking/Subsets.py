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
            currentSubset.append(nums[currentIndex])
            self.generateSubsets(currentIndex + 1, nums, currentSubset, result)
            
            # reset
            currentSubset.pop()

    def generateSubsetsII(self, firstIndex, nums, currentSubset, result):

        result.append(currentSubset[:])

        for i in range(currentIndex, len(nums)):

            currentSubset.append(nums[i])

            self.generateSubsetsII(i + 1, nums, currentSubset, result)

            currentSubset.pop()