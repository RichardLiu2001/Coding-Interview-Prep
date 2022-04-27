class Solution:

    # at each index, add to current partition or start a new one
    def partition(self, s: str) -> List[List[str]]:
        
        result = []

        if len(s) == 0:
            return result

        palindromeMemo = [[False for _ in range(len(s))] for _ in range(len(s))]

        self.partitionBacktrack(s, 0, [], result, palindromeMemo)

        return result


    def partitionBacktrack(self, s, currentIndex, currentPartition, result, palindromeMemo):

        if currentIndex == len(s):

            result.append(currentPartition[:])
            return
        
        currentChar = s[currentIndex]

        for end in range(currentIndex, len(s)):

            if :

                currentPartition.append(s[currentIndex:end+1])
                self.partitionBacktrack(s, end + 1, currentPartition, result)
                currentPartition.pop()
