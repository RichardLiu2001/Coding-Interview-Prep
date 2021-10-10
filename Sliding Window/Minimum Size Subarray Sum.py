class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        min_length = len(nums) + 1

        current_sum = 0

        window_start = 0

        for window_end in range(len(nums)):

            # add the current number to current sum, since the window_end grew by 1
            current_sum += nums[window_end]

            # once the sum of the current window is >= target, we can start shrinking
            while current_sum >= target:

                current_length = window_end - window_start + 1

                # immediately update min_length
                min_length = min(min_length, current_length)

                current_sum -= nums[window_start]

                window_start += 1

        if min_length == len(nums) + 1:
            return 0

        return min_length