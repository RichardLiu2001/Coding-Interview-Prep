class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        self.getCombinations(0, [], candidates, target, result)

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

        currentCombination.append(currentNum)
        self.getCombinations(currentIndex, currentCombination, candidates, target - currentNum, result)
        currentCombination.pop()

        self.getCombinations(currentIndex + 1, currentCombination, candidates, target, result)