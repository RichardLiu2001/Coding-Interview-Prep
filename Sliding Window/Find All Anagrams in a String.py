class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        result = []

        if len(s) < len(p):
            return result

        p_freqs = {}

        # populate frequency dict of s
        for c in p:
            if c not in p_freqs:
                p_freqs[c] = 0
            p_freqs[c] += 1

        window_freqs = {}
        
        window_start = 0

        for window_end in range(len(s)):

            current_char = s[window_end]

            if current_char not in window_freqs:
                window_freqs[current_char] = 0

            window_freqs[current_char] += 1

            if window_freqs == p_freqs:
                result.append(window_start)

            # if our window is now the length of p, we need to shrink it so that it will
            # grow to the proper size in the next iteration of the loop

            # valid anagrams mean that the window has to be exactly the same length as p
            if window_end - window_start + 1 == len(p):

                start_char = s[window_start]
                
                window_freqs[start_char] -= 1
                if window_freqs[start_char] == 0:
                    del window_freqs[start_char]

                window_start += 1

        return result
