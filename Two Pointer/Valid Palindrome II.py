class Solution:

    def validPalindrome(self, s: str) -> bool:
        
        l = 0
        r = len(s) - 1

        while l < r:

            if s[l] != s[r]:

                # if the current l and r don't match, try skipping each one

                # s[l + r] is skipping r
                # s[l + 1, r + 1] is skipping l
                return self.isPalindrome(s[l:r]) or self.isPalindrome(s[l + 1:r+1])

            l += 1

            r -= 1

        return True

    def isPalindrome(self, s):

        l = 0
        r = len(s) - 1

        while l < r:

            if s[l] != s[r]:
                return False

            l += 1 
            r -= 1

        return True