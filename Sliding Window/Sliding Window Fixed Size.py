def sliding_window_fixed_size(arr, fixed_size):

	window_start = 0

	current_window = 0

	optimal_window = -1

	for window_end in range(len(arr)):

		# after we've done the preliminary expanding, at the beginning of each loop, 
		# our window will be of size k - 1
		
		# expand the window by 1 to make the window size k
		current_window += arr[window_end]

		# only update max size and shrink once we've reached a window of size k
		# otherwise, we just initially grow our window to size k
		if window_end >= fixed_size:

			update_optimal_window(optimal_window, current_window)

			# shrink window from the front by 1
			current_window -= arr[window_start]

			window_start -= 1


	return optimal_window