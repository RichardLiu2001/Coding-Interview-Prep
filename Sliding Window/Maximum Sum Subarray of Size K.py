def max_sub_array_of_size_k(k, arr):
  
  if len(arr) < k:
    return -1

  window_start = 0

  max_sum = -1

  current_sum = 0

  for window_end in range(len(arr)):

    # after we've done the preliminary expanding, at the beginning of each loop, 
    # our window will be of size k - 1

    # expand the window by 1 to make the window size k
    current_sum += arr[window_end]

    # only update max size and shrink once we've reached a window of size k
    # otherwise, we just initially grow our window to size k
    if window_end >= k - 1:

      max_sum = max(max_sum, current_sum)

      # shrink the window from the left by 1
      current_sum -= arr[window_start]

      window_start += 1

  return max_sum


