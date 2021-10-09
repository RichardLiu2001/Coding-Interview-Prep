class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        n = len(nums)

        min_len = n + 1

        left = 0

        current_sum = 0

        for i in range(len(nums)):
            current_sum += nums[i]

            while current_sum >= target:

                current_length = i - left + 1

                min_len = min(min_len, current_length)
                
                current_sum -= nums[left]

                left += 1


        if min_len == n + 1:
            return 0

        return min_len
