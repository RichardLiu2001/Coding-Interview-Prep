class Solution:

    # at each index, add to current partition or start a new one
    def partition(self, s: str) -> List[List[str]]:
        
        result = []

        if len(s) == 0:
            return result

        self.partitionBacktrack(s, 0, [], result)

        return result


    def partitionBacktrack(self, s, currentIndex, currentPartition, result):


        if currentIndex == len(s):

            result.append(currentPartition[:])
            return
        
        currentChar = s[currentIndex]

        for i in range(currentIndex, len(s)):

            if self.isPalindrome(s[currentIndex:i + 1]):
                currentPartition.append(s[currentIndex:i+1])
                self.partitionBacktrack(s, i + 1, currentPartition, result)
                currentPartition.pop()


    def isPalindrome(self, s):

        return s == s[::-1]
