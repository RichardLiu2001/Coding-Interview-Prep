class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        left = 0

        right = len(s) - 1

        while left < right:

            # skip left pointer until next alphanumeric
            # need left < right condition since it could be broken when incrementing left
            while left < right and not s[left].isalnum():
                left += 1

            # skip right pointer until first alphanumeric
            while left < right and not s[right].isalnum():
                right -= 1

            if s[left].lower() != s[right].lower():
                return False

            left += 1
            right -=  1

        return True