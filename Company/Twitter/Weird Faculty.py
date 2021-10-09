# https://leetcode.com/discuss/interview-question/374440/Twitter-or-OA-2019-or-Weird-Faculty

def exam(verdicts):

	total_sum = 0

	for score in verdicts:
		if score == 0:
			total_sum -= 1
		else:
			total_sum += 1


	current_sum = 0

	for i, score in enumerate(verdicts):
		if current_sum > total_sum:
			return i


		score_contribution = 1

		if score == 0:
			score_contribution = -1

		current_sum += score_contribution
		total_sum -= score_contribution


	return len(verdicts)

	