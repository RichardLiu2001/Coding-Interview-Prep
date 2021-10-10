import collections 

class Solution:
    def lengthOfLongestSubstringKDistinctFreqs(self, s: str, k: int) -> int:
        
        longest = 0

        window_start = 0

        # maps each char to its frequency
        current_substring_chars = {}

        for window_end in range(len(s)):

            current_char = s[window_end]

            if current_char in current_substring_chars:
                current_substring_chars[current_char] += 1

            else:
                current_substring_chars[current_char] = 1

            # If we've exceeded the max number of distinct characters:
            while len(current_substring_chars) > k:

                starting_char = s[window_start]

                current_substring_chars[starting_char] -= 1

                if current_substring_chars[starting_char] == 0:

                    del(current_substring_chars[starting_char])

                window_start += 1

            longest = max(longest, window_end - window_start + 1)


        return longest


        def lengthOfLongestSubstringKDistinctOrderedDict(self, s: str, k: int) -> int:

            longest = 0

            window_start = 0

            # maps each character to the rightmost index of its occurrence
            # the characters are ordered by order of insertion: characters will be inserted to the "end", 
            # and the oldest characters (inserted the earliest) will be at the "front"
            current_substring_chars = collections.OrderedDict()

            for window_end in range(len(s)):

                current_char = s[window_end]

                # if the ordered dictionary already has the character, we need to delete it and put it again
                # this preserves the order of insertion (puts the character back at the end) - updating the 
                # character will not update the element's order in the dictionary
                if current_char in current_substring_chars:
                    del(current_substring_chars[current_char])

                current_substring_chars[current_char] = window_end

                if len(current_substring_chars) > k:

                    # remove the "oldest" character, the one whose rightmost index is the furthest to the left
                    # in other words, the character at the front of the dictionary (FIFO)

                    oldest_char, oldest_char_index = current_substring_chars.popitem(last=False)

                    window_start = oldest_char_index + 1

                longest = max(longest, window_end - window_start + 1)
            
            return longest

