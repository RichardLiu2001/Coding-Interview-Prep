def sliding_window_general(window):

	window_start = 0

	optimal_window = None

	current_window = None
	# grow the window
	for window_end in range(len(window)):

		update_current_window(current_window)

		while not fulfills_window_condition(current_window):

			shrink_window(window)
			# usually incrementing window_start

		optimal_window = compare(current_window, optimal_window)

	return optimal_window