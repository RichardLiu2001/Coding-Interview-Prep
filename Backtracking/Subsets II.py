class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        result = []

        # to detect duplicates
        nums.sort()

        self.subsetsWithDupHelp(nums, 0, [], result)

        return result


    def subsetsWithDupHelp(self, nums, firstIndex, currentSubset, result):

        result.append(currentSubset[:])

        for i in range(firstIndex, len(nums)):

            # avoid duplicate
            if i != firstIndex and nums[i] == nums[i - 1]:
                continue

            currentSubset.append(nums[i])

            self.subsetsWithDupHelp(nums, i + 1, currentSubset, result)

            currentSubset.pop()