class Solution:

    def closestDiffTwo(self, nums, target, i):

        # store the actual closest difference (can be negative)
        # we need the actual difference to get back the actual sum
        closest_diff = sys.maxsize

        left = i + 1
        right = len(nums) - 1

        while left < right:

            current_sum = nums[i] + nums[left] + nums[right]
            current_diff = target - current_sum

            if current_diff == 0:
                return current_diff

            if abs(current_diff) < abs(closest_diff):
                closest_diff = current_diff

            if current_sum < target:

                left += 1

            else:

                right -= 1

        return closest_diff


    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        # store the actual closest difference (can be negative)
        # we need the actual difference to get back the actual sum
        closest_diff = sys.maxsize

        nums.sort()

        for i in range(len(nums)):

            current_closest_diff = self.closestDiffTwo(nums, target, i)

            if current_closest_diff == 0:
                return target

            if abs(current_closest_diff) < abs(closest_diff):
                closest_diff = current_closest_diff
                

        return target - closest_diff

