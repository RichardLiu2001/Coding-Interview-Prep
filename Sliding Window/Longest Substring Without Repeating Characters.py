class Solution:
    def lengthOfLongestSubstringSet(self, s: str) -> int:
        
        window_start = 0

        longest = 0

        substring_chars = set()

        for window_end in range(len(s)):

            current_char = s[window_end]

            # we need to remove characters from the front of the window until we get rid of 
            # the first occurence of the current char, which is duplicated
            while current_char in substring_chars:

                front_char = s[window_start]

                substring_chars.remove(front_char)

                window_start += 1

            # add back in the current char, since we want to include it in the window
            substring_chars.add(current_char)

            longest = max(longest, len(substring_chars))

        return longest


    def lengthOfLongestSubstringDict(self, s: str) -> int:
        
        window_start = 0

        longest = 0

        # maps each character to its rightmost index that has been encountered
        substring_chars = {}

        for window_end in range(len(s)):

            current_char = s[window_end]

            if current_char in substring_chars:

                # window_start may already be ahead of the first occurence of the duplicate character.
                # if that's the case, we don't need to update window_start

                # if the first occurence of the duplicate character is after (or equal to) start, then we need to 
                # move start to the character after the first duplicate. 

                if substring_chars[current_char] >= window_start:
                    window_start = substring_chars[current_char] + 1                    
            
            # update the index of the current char to the current index
            substring_chars[current_char] = window_end
            
            longest = max(longest, window_end - window_start + 1)


        return longest

