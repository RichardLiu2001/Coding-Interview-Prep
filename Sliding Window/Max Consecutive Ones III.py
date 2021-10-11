class Solution:

    def longestOnes(self, nums: List[int], k: int) -> int:
        
        longest = 0

        window_start = 0

        # tracks the number of ones in the current window (while)

        # alternatively, tracks the greatest number of ones in any window (if)
        one_count = 0

        for window_end in range(len(nums)):

            current_num = nums[window_end]

            if current_num == 1:
                one_count += 1

            # we have too many zeroes, we need to shrink the window
            # can be a while, but if works because we're only interested 
            # in the longest window

            # the if statement makes us slide a window of the current size until
            # it contains one_count ones again.
            if window_end - window_start + 1 - one_count > k:

                front_num = nums[window_start]

                if front_num == 1:
                    one_count -= 1

                window_start += 1

            longest = max(longest, window_end - window_start + 1)

        return longest


