def cyclic_sort(nums):

  # nums contains numbers from 1 to n

  current_index = 0

  while current_index < len(nums):

    current_number = nums[current_index]

    # the index that the current number is supposed to be at
    correct_index = current_number - 1

    # the current number is not in the right index
    if nums[correct_index] != current_number:

      # swap the current number with the number that was in its spot
      nums[correct_index], nums[current_index] = nums[current_index], nums[correct_index]

      # then, reconsider the new number that was swapped to the current index
    else:

      # current number is in the correct index, move to next index
      current_index += 1

  return nums
