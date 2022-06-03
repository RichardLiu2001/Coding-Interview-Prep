class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        result = []

        nums.sort()

        self.subsetsWithDupHelp(nums, 0, [], result)

        return result


    def subsetsWithDupHelp(self, nums, currentIndex, currentSubset, result):

        result.append(currentSubset[:])

        for i in range(currentIndex, len(nums)):

            # avoid duplicate
            if i != index and nums[i] == nums[i - 1]:
                continue

            currentSubset.append(nums[i])

            self.subsetsWithDupHelp(nums, i + 1, currentSubset, result)

            currentSubset.pop()



            