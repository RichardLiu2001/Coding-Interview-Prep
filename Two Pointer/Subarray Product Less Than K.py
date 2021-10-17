class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        
        # All numbers in nums are at least 1, so there are no subarrays with
        # a product that is strictly less than 1
        if k <= 1:
            return 0
        
        valid_subarray_count = 0

        window_start = 0

        window_product = 1

        for window_end in range(len(nums)):

            # add this current num to the window
            window_product *= nums[window_end]

            # shrink the window
            while window_product >= k:

                # we do not have to worry about the 0 case - k is > 1 at this point,
                # so if we add a 0, we will never have to shrink the window since
                # the product will always be 0, which is < k
                window_product /= nums[window_start]

                window_start += 1

            # if we add an element to the current window, we add a subarray for each 
            # element in the window (apart from the added one), and one more to 
            # account for the subarray with just the element itself. 
            valid_subarray_count += window_end - window_start + 1


        return valid_subarray_count