class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        # index of where we should insert the next largest number, starting at the end of nums1
        # so that we don't have to worry about overwriting
        insertIndex = len(nums1) - 1
        
        # index of the largest number in nums1 that we haven't inserted yet
        nums1MaxIndex = m - 1
        # index of the largest number in nums2 that we haven't inserted yet
        nums2MaxIndex = n - 1
        
        while insertIndex >= 0:

            # if nums2MaxIndex < 0, there are no more numbers to insert from nums2.
            # we can quit the loop since the rest of nums1 is already sorted.
            if nums2MaxIndex < 0:
                break

            nums1Num = nums1[nums1MaxIndex]
            nums2Num = nums2[nums2MaxIndex]

            # if nums1MaxIndex is < 0, just skip and fill in from nums2
            if nums1MaxIndex >= 0 and nums1Num >= nums2Num:

                nums1[insertIndex] = nums1Num
                nums1MaxIndex -= 1

            else:

                nums1[insertIndex] = nums2Num
                nums2MaxIndex -= 1

            insertIndex -= 1
    