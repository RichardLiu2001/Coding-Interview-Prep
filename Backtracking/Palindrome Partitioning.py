class Solution:

    # at each index, add to current partition or start a new one
    def partition(self, s: str) -> List[List[str]]:
        
        result = []

        if len(s) == 0:
            return result

        # palindromeMemo[i][j] indicates if s[i:j] is a palindrome
        palindromeMemo = [[False for _ in range(len(s))] for _ in range(len(s))]

        self.partitionBacktrack(s, 0, [], result, palindromeMemo)

        return result


    def partitionBacktrack(self, s, beginPalindromeIndex, currentPartition, result, palindromeMemo):

        if beginPalindromeIndex == len(s):

            result.append(currentPartition[:])
            return
        
        currentChar = s[beginPalindromeIndex]

        # choice: where to end the current palindrome
        for end in range(beginPalindromeIndex, len(s)):

            #if self.isPalindrome(s[currentIndex:end+1]):

            # checking if the substring from currentIndex to end+1 is a palindrome
            
            # if the end char matches the beginning char (could be the same index) and either (the end char is <= 2 ahead aka 
            # the substring is of length 1 or 2, or everything in the middle is already known to be a palindrome)
            if s[end] == s[beginPalindromeIndex] and (end - beginPalindromeIndex <= 2 or palindromeMemo[beginPalindromeIndex + 1][end - 1]):

                palindromeMemo[beginPalindromeIndex][end] = True
                # make choice to end the current palindrome at index end (end + 1 for substring indexing)
                currentPartition.append(s[beginPalindromeIndex:end+1])
                self.partitionBacktrack(s, end + 1, currentPartition, result, palindromeMemo)
                currentPartition.pop()

    def isPalindrome(self, a):

        return a == a[::-1]