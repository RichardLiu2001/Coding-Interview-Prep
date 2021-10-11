class Solution:
    def characterReplacementMaxFreq(self, s: str, k: int) -> int:
        
        longest = 0

        window_start = 0

        char_freqs = {}

        for window_end in range(len(s)):

            current_char = s[window_end]

            if current_char not in char_freqs:
                char_freqs[current_char] = 0

            char_freqs[current_char] += 1

            # window_end - window_start + 1 = the length of the current window
            # the length of the current window - the frequency of the most frequently 
            # appearing character = the number of characters we need to replace.

            # This has to be at most k

            # Does not have to be a while loop, since it will only run once
            # Shifting the window over, rather than shrinking it
            if (window_end - window_start + 1) - max(char_freqs.values()) > k:

                front_char = s[window_start]

                char_freqs[front_char] -= 1

                window_start += 1

            longest = max(longest, window_end - window_start + 1)

        return longest


    def characterReplacementOptimized(self, s: str, k: int) -> int:

        longest = 0

        window_start = 0

        char_freqs = {}

        # tracks the count of the maximum repeating letter in any window
        # that was looked at before the current window
        max_freq = 0

        for window_end in range(len(s)):

            current_char = s[window_end]

            if current_char not in char_freqs:
                char_freqs[current_char] = 0

            char_freqs[current_char] += 1

            # if the count of the newly added character in the current window
            # exceeds max_freq, we update it. Otherwise, we leave max_freq alone.

            # Because max_freq never gets decremented (since it tracks the historically largest frequency),
            # it might be larger than the frequency of the most frequently appearing character in the current 
            # window. However, this is ok since we are only interested in the longest window, which must have 
            # a character duplicated at least max_freq times.
            # Otherwise, the length of the current window cannot beat what we already found before.
            max_freq = max(max_freq, char_freqs[current_char])

            # Does not have to be a while loop, since it will only run once
            # Shifting the window over, rather than shrinking it
            if (window_end - window_start + 1 - max_freq > k):
                
                front_char = s[window_start]

                window_start += 1

                char_freqs[front_char] -= 1

            longest = max(longest, window_end - window_start + 1)

        return longest


