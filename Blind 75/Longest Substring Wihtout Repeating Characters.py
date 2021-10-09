class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        current_chars = set()

        n = len(s)

        longest = 0

        left = 0

        if n < 2:
            return n

        for i in range(n):
            current = s[i]

            if current not in current_chars:
                current_chars.add(current)
                longest = max(longest, len(current_chars))

            else:

                while current in current_chars:
                    current_chars.remove(s[left])
                    left += 1

            current_chars.add(current)

        return longest