def backtrack(arguments):

	resultList = []

	backtrackHelp(arguments, initialStep, emptySolution, resultList)

	return resultList


def backtrackHelp(arguments, currentStep, currentSolution, resultList):

	if base_case:

		add_solution(currentSolution) or discard_solution(currentSolution)

		return

	# try all options
	for nextStep in all_steps_from_current(currentStep):

		# try option
		currentSolution.append(currentStepElement)
		backtrackHelp(arguments, nextStep, currentSolution, resultList)
		
		# undo choice to make a clean slate for future choices
		currentSolution.pop()