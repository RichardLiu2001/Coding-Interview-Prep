class Solution:

    # at each index, add to current partition or start a new one
    def partition(self, s: str) -> List[List[str]]:
        
        result = []

        if len(s) == 0:
            return result

        self.partitionBacktrack(s, 0, [], "", result)

        return result


    def partitionBacktrack(self, s, currentIndex, currentPartition, currentCandidatePalindrome, result):


        if currentIndex == len(s):

            result.append(currentPartition[:])
            return
        
        currentChar = s[currentIndex]

        # if current candidate palindrome is palindrome: 2 choices: create new palindrome or continue adding to it

        # if current candidate is not palindrome, must add currentChar to it

        if currentCandidatePalindrome != "" and self.isPalindrome(currentCandidatePalindrome):

            # create new palindrome
            currentPartition.append(currentCandidatePalindrome)
            self.partitionBacktrack(s, currentIndex + 1, currentPartition, currentChar, result)

            currentPartition.pop()
            # add on to current palindrome
            self.partitionBacktrack(s, currentIndex + 1, currentPartition, currentCandidatePalindrome + currentChar, result)



        else:

            self.partitionBacktrack(s, currentIndex + 1, currentPartition, currentCandidatePalindrome + currentChar, result)


    def isPalindrome(self, s):

        return s == s[::-1]
