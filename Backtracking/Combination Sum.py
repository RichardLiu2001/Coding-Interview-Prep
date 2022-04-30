class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        self.getCombinations(0, [], candidates, target, result)
        #self.getCombinationsLoop(0, [], candidates, target, result)

        return result

    def getCombinations(self, currentIndex, currentCombination, candidates, target, result):

        if target == 0:

            result.append(currentCombination[:])
            return

        if target < 0:

            return

        if currentIndex == len(candidates):
            return

        currentNum = candidates[currentIndex]

        # use the number at the current index
        # don't increment current index because we can use the same number multiple times
        currentCombination.append(currentNum)
        self.getCombinations(currentIndex, currentCombination, candidates, target - currentNum, result)
        currentCombination.pop()

        # skip the number at the current index
        self.getCombinations(currentIndex + 1, currentCombination, candidates, target, result)

        # Questions
        # 1. Why does this prevent duplicates?
            # because you're generating combinations only going forward
        
        # 2. How does the LeetCode solution with the for loop work?
        # It implicitly skips numbers in each iteration in the for loop - the loop
        # selects the next number to use. By not selecting some numbers, it implcitly skips them.

    def getCombinationsLoop(self, currentIndex, currentCombination, candidates, target, result):

        if target == 0:

            result.append(currentCombination[:])
            return

        if target < 0:
            return

        if currentIndex == len(candidates):
            return

        # i represents the index of the next number we're going to add.
        # since we start i at currentIndex, it will not go backwards.
        # also, this means that we will completely skip all the numbers between 
        # currentIndex and i (done implicitly)
        for i in range(currentIndex, len(candidates)):

            # try using the number at index i
            numToTry = candidates[i]

            currentCombination.append(numToTry)

            self.getCombinationsLoop(i, currentCombination, candidates, target - numToTry, result)

            currentCombination.pop()



