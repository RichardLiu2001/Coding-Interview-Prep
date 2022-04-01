class Solution:
    def minWindow(self, s: str, t: str) -> str:
    
        # s cannot contain a substring of t if t is longer than s
        if len(t) > len(s):
            return ""

        # frequencies of all characters in t
        t_freqs = {}

        # populate t_freqs
        for character in t:

            if character not in t_freqs:
                t_freqs[character] = 0

            t_freqs[character] += 1


        # how many unique characters we have left to find
        chars_remaining = len(t_freqs)

        # how many total characters we have to find
        #chars_remaining = len(t)


        min_window_left = 0
        min_window_right = len(s) - 1
        min_window_len = float("inf")

        left = 0

        for right in range(len(s)):

            cur_letter = s[right]

            if cur_letter in t_freqs:
                t_freqs[cur_letter] -= 1

                #if t_freqs[cur_letter] >= 0:

                # reached quota for that one character
                if t_freqs[cur_letter] == 0:
                    chars_remaining -= 1


            while chars_remaining == 0:

                if right - left + 1 < min_window_len:
                    min_window_left = left
                    min_window_right = right
                    min_window_len = right - left + 1

                # shrink window

                left_char = s[left]

                if left_char in t_freqs:
                    t_freqs[left_char] += 1

                    #if t_freqs[left_char] >= 1:

                    # now have 1 unique character to match, current window no longer contains all of t
                    if t_freqs[left_char] == 1:
                        chars_remaining += 1

                left += 1

        return "" if min_window_len == float("inf") else s[min_window_left:min_window_right + 1]
