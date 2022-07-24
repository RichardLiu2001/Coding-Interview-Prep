class Solution:
    def minWindow(self, s: str, t: str) -> str:
    
        # s cannot contain a substring of t if t is longer than s
        if len(t) > len(s):
            return ""

        # frequencies of all characters in t
        t_freqs = defaultdict(int)

        # populate t_freqs
        for character in t:

            t_freqs[character] += 1

        # how many unique characters we have left to find
        chars_remaining = len(t_freqs)

        min_window_left = 0
        min_window_right = len(s) - 1
        min_window_len = float("inf")

        window_start = 0

        for window_end in range(len(s)):

            cur_letter = s[window_end]

            if cur_letter in t_freqs:
                t_freqs[cur_letter] -= 1

                # reached quota for that one character
                if t_freqs[cur_letter] == 0:
                    chars_remaining -= 1

            # Keep shrinking until the window doesn't contain the substring. We may be able to get
            # a more optimal solution than the initial window found if there are multiple excess
            # characters in the beginning (etc. looking for ABC in AAAAABC) -> get rid of all but 1 of the beginning A's.
            while chars_remaining == 0:

                current_window_length = window_end - window_start + 1

                if current_window_length < min_window_len:
                    min_window_left = window_start
                    min_window_right = window_end
                    min_window_len = current_window_length

                # shrink window
                left_char = s[window_start]

                if left_char in t_freqs:
                    t_freqs[left_char] += 1

                    # now have 1 unique character to match, current window no longer contains all of t
                    if t_freqs[left_char] == 1:
                        chars_remaining += 1

                window_start += 1

        return "" if min_window_len == float("inf") else s[min_window_left:min_window_right + 1]
