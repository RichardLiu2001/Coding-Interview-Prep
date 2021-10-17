class Solution:

    def smaller_triplets_from_index(self, nums, target, i):

        smaller_triplet_count = 0

        low = i + 1
        high = len(nums) - 1

        while low < high:

            current_sum = nums[i] + nums[low] + nums[high]

            if current_sum < target:

                # if low + high < target, then low + any other element
                # in the range will also be < target, since nums is sorted.

                # there is a total of high - low numbers in the range.
                smaller_triplet_count += high - low 

                # now, remove the element at low from consideration,
                # since we already calculated all of the triplets
                low += 1

            else:

                # remove the element at high from consideration,
                # it is too large
                high -= 1


        return smaller_triplet_count


    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        
        smaller_triplet_count = 0

        nums.sort()

        for i in range(len(nums)):

            smaller_triplet_count += self.smaller_triplets_from_index(nums, target, i)


        return smaller_triplet_count