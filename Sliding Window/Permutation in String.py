class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        if len(s1) > len(s2):
            return False

        # stores the frequencies of all the characters in s1
        s1_freqs = {}

        for character in s1:
            if character not in s1_freqs:
                s1_freqs[character] = 0

            s1_freqs[character] += 1

        # stores the frequencies of all the characters in the current window
        window_freqs = {}

        window_start = 0

        for window_end in range(len(s2)):
        
            current_char = s2[window_end]

            if current_char not in window_freqs:
                window_freqs[current_char] = 0

            window_freqs[current_char] += 1

            # if the frequencies of the window and s1 match, we have an anagram
            if window_freqs == s1_freqs:
                return True

            # Only shrink (slide) the window if it is the length of s1
            if window_end - window_start + 1 == len(s1):

                front_char = s2[window_start]

                window_freqs[front_char] -= 1

                if window_freqs[front_char] == 0:
                    del(window_freqs[front_char])

                window_start += 1

        return False


    def checkInclusion(self, s1: str, s2: str) -> bool:


        if len(s1) > len(s2):
            return False

        # stores the frequency of each character in s1
        s1_freqs = {}

        # stores the number of characters in the current sliding window
        # that are all completely matched with the same character in s1

        # e.g if s1 had 2 a's and the current window also had 2 a's, then 
        # we would increment this. However, there must be exactly the same number
        all_matched_chars = 0
    
        for character in s1:
            if character not in s1_freqs:
                s1_freqs[character] = 0

            s1_freqs[character] += 1
        
        window_start = 0

        for window_end in range(len(s2)):

            current_char = s2[window_end]

            if current_char in s1_freqs:

                s1_freqs[current_char] -= 1

                # if we've matched all of a particular character in the current
                # window to those in s1, we can update all_matched_chars for that char
                if s1_freqs[current_char] == 0:

                    all_matched_chars += 1

            # If we've matched all of every char in the window to s1, then we have 
            # an anagram
            if all_matched_chars == len(s1_freqs):
                return True

            # Only shrink (slide) the window if it is the length of s1
            if window_end - window_start + 1 == len(s1):


                front_char = s2[window_start]

                if front_char in s1_freqs:

                    # this char was previously all matched, but now we're getting rid of it
                    # so we have to update all_matched_chars
                    if s1_freqs[front_char] == 0:

                        all_matched_chars -= 1

                    s1_freqs[front_char] += 1

                window_start += 1

        return False

