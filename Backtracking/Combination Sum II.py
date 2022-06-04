class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []

        candidates.sort()

        self.combinationSum2Help(candidates, target, 0, [], result)

        return result


    def combinationSum2Help(self, candidates, target, startIndex, currentCombination, result):

        if target == 0:

            result.append(currentCombination[:])
            return

        if target < 0:
            return

        # try each remaining index as where we start picking numbers from (firstIndex)
        for i in range(startIndex, len(candidates)):

            if i != startIndex and candidates[i] == candidates[i - 1]:

                continue

            currentNum = candidates[i]

            # stop early. since the array is sorted, we no longer have to look further 
            # if the currentNum already makes the target negative
            if target - currentNum < 0:
                break

            # try adding currentNum
            currentCombination.append(currentNum)
            self.combinationSum2Help(candidates, target - currentNum, i + 1, currentCombination, result)
            currentCombination.pop()