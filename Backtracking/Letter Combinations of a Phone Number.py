# Map all the digits to their corresponding letters
letters = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", 
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        result = []

        if len(digits) == 0:
            return result

        self.generateCombinations(digits, 0, "", result)

        return result

    def generateCombinations(self, digits, currentIndex, currentString, result):

        if currentIndex == len(digits):

            result.append(currentString)

        else:

            currentDigit = digits[currentIndex]

            for possibleChar in letters[currentDigit]:

                self.generateCombinations(digits, currentIndex + 1, currentString + possibleChar, result)