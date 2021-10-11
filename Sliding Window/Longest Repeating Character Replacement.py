class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        longest = 0

        window_start = 0

        char_freqs = {}

        for window_end in range(len(s)):

            current_char = s[window_end]