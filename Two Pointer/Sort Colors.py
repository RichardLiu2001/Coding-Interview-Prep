class Solution:

    def sortColors(self, nums: List[int]) -> None:

        zero_index = 0

        i = 0

        two_index = len(nums) - 1

        while i <= two_index:

            current_num = nums[i]

            if current_num == 0:

                nums[zero_index], nums[i] = nums[i], nums[zero_index]
                i += 1
                zero_index += 1

            elif current_num == 2:

                nums[two_index], nums[i] = nums[i], nums[two_index]

                # don't advance current, because now it holds whatever was 
                # in the index of two_index, which we swapped

                # we still need to process what's now in current instead of skipping over it

                two_index -= 1

            else:
                i += 1

    def sortColorsRichard(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        zero_index = 0

        for fast_pointer in range(len(nums)):

            if nums[fast_pointer] == 0:
                nums[zero_index], nums[fast_pointer] = nums[fast_pointer], nums[zero_index]
                zero_index += 1


        for fast_pointer in range(zero_index, len(nums), 1):

            if nums[fast_pointer] == 1:
                nums[zero_index], nums[fast_pointer] = nums[fast_pointer], nums[zero_index]
                zero_index += 1

