import random

# looking for the kth smallest element in nums
# k is using 0 based indexing (0th smallest is the smallest, or what would
# appear at index 0 if the array was sorted)
def quickSelect(nums, left, right, k):

	# the index of the pivot, which we arbitrarily chose as the number 
	# at nums[right]
	pivot_index = partition(nums, left, right)

	if pivot_index > k:

		# k must be to the left of pivot_index
		return quickSelect(nums, left, right - 1, k)


	if pivot_index < k:

		# k must be to the right of pivot_index

		return quickSelect(nums, left + 1, right, k)


	# pivot_index == k
	return nums[k]


def partition(nums, left, right):

	# always use the rightmost value as the pivot
    pivot = nums[right]

    # to the left of this index are < pivot, to the right are > pivot
    separating_index = left

    for i in range(left, right):

    	if nums[i] <= pivot:

    		# swap
    		nums[i], nums[separating_index] = nums[separating_index], nums[i]

    		separating_index += 1

    # insert the pivot value (which was at the end or right) to the separating index
    nums[right], nums[separating_index] = nums[separating_index], nums[right]

    return separating_index

nums = [0,1,2,3,4,5,6,7]
random.shuffle(nums)
print(str(quickSelect(nums, 0, 7, 0)))

