class Solution:
    def twoSumSorted(self, result, nums, i):

        left = i + 1
        right = len(nums) - 1

        while left < right:

            sum = nums[i] + nums[left] + nums[right]

            if sum == 0:
                result.append([nums[i], nums[left], nums[right]])
                left += 1
                right -= 1

                # skip duplicates starting from the left, to get unique triplets
                while left < right and nums[left] == nums[left - 1]:
                    left += 1
                #while left < right and nums[right] == nums[right + 1]:
                #    right -= 1
                
            elif sum < 0:
                left += 1

            else:
                right -= 1



    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) < 2:
            return []

        nums.sort()

        result = []

        for i in range(len(nums)):

            # we want to skip duplicate numbers, which will be next to 
            # each other because the array is sorted
            if i == 0 or nums[i] != nums[i - 1]:

                self.twoSumSorted(result, nums, i)

        return result