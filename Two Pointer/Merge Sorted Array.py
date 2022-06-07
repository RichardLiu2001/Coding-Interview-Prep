class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        insertIndex = len(nums1) - 1
        
        nums1MaxIndex = m - 1
        nums2MaxIndex = n - 1
        
        while insertIndex >= 0:

            if nums2MaxIndex < 0:
                break

            nums1Num = nums1[nums1MaxIndex]
            nums2Num = nums2[nums2MaxIndex]
            print("1 index: " + str(nums1MaxIndex))
            print("2 index: " + str(nums2MaxIndex))

            if nums1MaxIndex >= 0 and nums1Num >= nums2Num:

                nums1[insertIndex] = nums1Num
                print("inserting " + str(nums1Num))
                nums1MaxIndex -= 1

            else:

                nums1[insertIndex] = nums2Num
                nums2MaxIndex -= 1
                print("inserting " + str(nums2Num))


            insertIndex -= 1
    