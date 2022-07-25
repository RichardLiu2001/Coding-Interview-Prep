class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        if k > len(nums):
            raise Exception("Sliding window is larger than nums.")

        if k == 1:
            return nums

        result = []
        
        # Possible candidates in the current sliding window ordered from greatest to least (left to right)
        window = deque()

        for window_end in range(len(nums)):

            self.clean_window(window_end, window, nums, k)
            window.append(i)

            if window_end >= k - 1:
                result.append(nums[window[0]])

        return result


    # Removes ineligible numbers from the window
    def clean_window(self, window_end, window, nums, k):

        # We are trying to add nums[window_end] to the window, and remove nums[window_end - k]
        # For example, if we are adding index 3 and the window size is 2, we need to remove index 1 (3 -2)
        front_index_to_remove = window_end - k

        # If the best number in 
        if window and window[0] == front_index_to_remove:
            window.popleft()

        num_to_add = nums[window_end]

        while window and nums[window[-1]] < num_to_add:
            window.pop()