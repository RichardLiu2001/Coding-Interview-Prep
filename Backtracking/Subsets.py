class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        self.generateSubsets(0, nums, [], result)

        return result

    def generateSubsets(self, currentIndex, nums, currentSubset, result):

        if currentIndex == len(nums):
            result.append(currentSubset[:])
        else:

            self.generateSubsets(currentIndex + 1, nums, currentSubset, result)

            currentSubset.append(nums[i])
            self.generateSubsets(currentIndex + 1, nums, currentSubset, result)
            currentSubset.pop()


    # def subsets(self, nums: List[int]) -> List[List[int]]:
        
    #     result = []

    #     used = [False for _ in range(len(nums))]

    #     for i in range(len(nums) + 1):

    #         self.createSubsetsFixedSize(i, nums, used, [], result)

    #     return result

    def createSubsetsFixedSize(self, subsetSize, nums, used, currentSubset, result):

        if len(currentSubset) == subsetSize:

            result.append(currentSubset[:])

        else:

            for i in range(len(nums)):

                if not used[i]:
                    currentSubset.append(nums[i])
                    used[i] = True
                    self.createSubsetsFixedSize(subsetSize, nums, used, currentSubset, result)
                    currentSubset.pop()
                    #used[i] = False


# create a subset of size 2:
# 1, 2, 3, 4, 5, 6, 7, 8

# 1, 2, 3, 4, 5, 6, 7, 8


# take 1, combine with each of the other numbers. Remove 1.
# take 2, combine with each of the othe rnumbers. Remove 2.

# iterate from 1 to 7: 0 through len(nums) - subsetSize, 
# general: for i in range(len(nums) - subsetSize + 1)

    def createSubsetsFixedSize(self, subsetSize, nums, used, currentSubset, result):

        if len(currentSubset) == subsetSize:
            result.append(currentSubset[:])

        else:

            for i in range(0, len(nums) - subsetSize + 1):





