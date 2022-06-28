class Solution:
    def twoSumSorted(self, result, nums, i):

        left = i + 1
        right = len(nums) - 1

        while left < right:

            sum = nums[i] + nums[left] + nums[right]

            if sum > 0:

                right -= 1
            
            elif sum < 0:

                left += 1
            
            else:
                # sum == 0
                result.append((nums[i], nums[left], nums[right]))
                left += 1
                right -=1 

                # skip duplicates starting from the left, to get unique triplets
                while left < right and nums[left] == nums[left - 1]:
                    left += 1

                # once we have a different left, even if the right pointer encounters
                # a duplicate value from before, it will no longer create a valid triplet
                # since the left pointer now points to a different number.


    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) < 2:
            return []

        nums.sort()

        result = []

        for i in range(len(nums)):

            # optimization: since nums is sorted, anything greater than 0
            # cannot have pairs later on that will make the sum 0.
            if nums[i] > 0:
                break

            # we want to skip duplicate numbers, which will be next to 
            # each other because the array is sorted
            if i == 0 or nums[i] != nums[i - 1]:

                self.twoSumSorted(result, nums, i)

        return result