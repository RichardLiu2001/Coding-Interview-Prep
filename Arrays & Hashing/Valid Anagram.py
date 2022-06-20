class Solution:

    def isAnagram(self, s: str, t:str) -> bool:

        if len(s) != len(t):
            return False

        # defaultdict never returns a get key error, instead returns
        # value given by anonymous function passed in
        s_freqs = defaultdict(lambda: 0)

        for char in s:

            s_freqs[char] += 1

        for char in t:

            s_freqs[char] -= 1
        
        for char in s_freqs:

            if s_freqs[char] != 0:

                return False

        return True


    def isAnagramLettersOnly(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False

        s_freqs = [0 for _ in range(26)]

        for char in s:

            s_freqs[ord(char) - ord('a')] += 1

        for char in t:

            s_freqs[ord(char) - ord('a')] -= 1

        for char_freq in s_freqs:

            if char_freq != 0:
                return False

        return True

