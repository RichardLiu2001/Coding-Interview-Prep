class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:

        result = []

        left = 0
        right = len(nums) - 1

        # <=, try writing out an example
        # if <, then the = value will be skipped
        while left <= right:

            left_square = nums[left] * nums[left]
            right_square = nums[right] * nums[right]

            if left_square > right_square:

                result.append(left_square)
                left += 1

            else:

                result.append(right_square)
                right -= 1

        # we built up solution from greatest to least, because
        # the "outsides" of the sorted list indicate the greatest values
        result.reverse()
        
        return result





